package com.kh.youtube.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VideoComment {

    @Id
    @Column(name="comment_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "videoCommSequence")
    @SequenceGenerator(name="videoCommSequence", sequenceName = "SEQ_VIDEO_COMMENT", allocationSize = 1)
    private int commentCode;

    @Column(name="comment_desc")
    private String commentDesc;

    @Column(name="comment_date")
    private Date commentDate;

    @Column(name="comment_parent")
    private int commentParent;

    @Column(name="video_code")
    private int videoCode;

    @ManyToOne
    @JoinColumn(name="id")
    private Member member;
}
