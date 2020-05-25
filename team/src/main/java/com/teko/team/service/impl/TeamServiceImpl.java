package com.teko.team.service.impl;

import com.teko.domain.Team;
import com.teko.proto.*;
import com.teko.repository.TeamRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class TeamServiceImpl extends TeamServiceGrpc.TeamServiceImplBase {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void getAll(GetAllTeamRequest request, StreamObserver<TeamTranfer> responseObserver) {
        List<Team> teams = teamRepository.findAll();
        teams.forEach(team -> {
            responseObserver.onNext(team.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetTeamByIdRequest request, StreamObserver<TeamTranfer> responseObserver) {
        Optional<Team> team = teamRepository.findById(request.getId());
        team.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteTeamByIdRequest request, StreamObserver<Empty> responseObserver) {
        teamRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddTeamRequest request, StreamObserver<TeamTranfer> responseObserver) {
        Team team = Team.fromProto(request.getTeam());
        Team response = teamRepository.save(team);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateTeamRequest request, StreamObserver<TeamTranfer> responseObserver) {
        Team team = Team.fromProto(request.getTeam());
        Team response = teamRepository.saveAndFlush(team);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
