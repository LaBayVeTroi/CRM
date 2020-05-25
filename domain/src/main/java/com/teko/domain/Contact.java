package com.teko.domain;

import com.teko.proto.ContactTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contact")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String description;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "is_active")
    private boolean isActive;
    private String phone;

    @OneToOne
    @JoinColumn(name = "address")
    private Address address;

    @ManyToMany
    @JoinTable(name = "contact_assigned_to", joinColumns = @JoinColumn(name = "contact_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addresses;

    @OneToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @ManyToMany
    @JoinTable(name = "contact_team", joinColumns = @JoinColumn(name = "contact_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Team> teams;

    public static Contact fromProto(ContactTranfer contactTranfer){
        List<Address> addresses = new ArrayList<>();
        contactTranfer.getAddressesList().forEach(addressTranfer -> {
            addresses.add(Address.fromProto(addressTranfer));
        });
        List<Team> teams = new ArrayList<>();
        contactTranfer.getTeamsList().forEach(teamTranfer -> {
            teams.add(Team.fromProto(teamTranfer));
        });
        return Contact.builder()
                .id(contactTranfer.getId())
                .firstName(contactTranfer.getFirstName())
                .lastName(contactTranfer.getLastName())
                .email(contactTranfer.getEmail())
                .description(contactTranfer.getDescription())
                .createdOn(new Date(contactTranfer.getCreatedOn()))
                .isActive(contactTranfer.getIsActive())
                .phone(contactTranfer.getPhone())
                .address(Address.fromProto(contactTranfer.getAddress()))
                .addresses(addresses)
                .createdBy(User.fromProto(contactTranfer.getCreatedBy()))
                .teams(teams)
                .build();
    }

    public ContactTranfer toProto(){
        ContactTranfer.Builder builder = ContactTranfer.newBuilder();
        for(int i=0;i<this.addresses.size();i++){
            builder.setAddresses(i,this.addresses.get(i).toProto());
        }
        for(int i=0;i<this.teams.size();i++){
            builder.setTeams(i,this.teams.get(i).toProto());
        }
        builder.setId(this.id)
                .setFirstName(this.firstName)
                .setLastName(this.lastName)
                .setEmail(this.email)
                .setDescription(this.description)
                .setCreatedOn(this.createdOn.getTime())
                .setIsActive(this.isActive)
                .setPhone(this.phone)
                .setAddress(this.address.toProto())
                .setCreatedBy(this.createdBy.toProto());
        return builder.build();
    }
}
