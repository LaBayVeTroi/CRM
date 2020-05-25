package com.teko.domain;

import com.teko.proto.CommentFileTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.File;
import java.sql.Date;

@Data
@Entity
@Table(name = "comment_file")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentFile {
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
    @Column(name = "updated_on")
    private Date updatedOn;
    @Column(name = "comment_file")
    private File commentFile;
    @ManyToOne
    @JoinColumn(name = "comment")
    private Comment comment;

    public static CommentFile fromProto(CommentFileTranfer commentFileTranfer){
        return CommentFile.builder()
                .id(commentFileTranfer.getId())
                .updatedOn(new Date(commentFileTranfer.getUpdatedOn()))
                .commentFile(new File(commentFileTranfer.getCommentFile()))
                .comment(Comment.fromProto(commentFileTranfer.getComment()))
                .build();
    }

    public CommentFileTranfer toProto(){
        return CommentFileTranfer.newBuilder()
                .setId(this.id)
                .setUpdatedOn(this.updatedOn.getTime())
                .setCommentFile(this.commentFile.getAbsolutePath())
                .setComment(this.comment.toProto())
                .build();
    }
}
