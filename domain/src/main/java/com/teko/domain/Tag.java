package com.teko.domain;

import com.google.protobuf.GeneratedMessageV3;
import com.teko.proto.TagTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tag")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tag{
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
    private String name;
    private String slug;

    public static Tag fromProto(TagTranfer tagTranfer) {
        return Tag.builder()
                .id(tagTranfer.getId())
                .name(tagTranfer.getName())
                .slug(tagTranfer.getSlug())
                .build();
    }

    public TagTranfer toProto() {
        return TagTranfer.newBuilder()
                .setId(this.id)
                .setName(this.name)
                .setSlug(this.slug)
                .build();
    }
}
