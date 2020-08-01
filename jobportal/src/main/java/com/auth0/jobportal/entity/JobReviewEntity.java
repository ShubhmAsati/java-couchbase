//package com.auth0.jobportal.entity;
//
//import com.auth0.jobportal.entity.jsonMapper.Reviews;
//import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.Type;
//import org.hibernate.annotations.TypeDef;
//import org.hibernate.annotations.TypeDefs;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@TypeDefs({
//        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
//})
//public class JobReviewEntity extends BaseEntity{
//
//    @Id
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "", referencedColumnName = "")
//    private long jobId;
//
//    @Type(type = "jsonb")
//    @Column(columnDefinition = "jsonb")
//    @Basic(fetch = FetchType.LAZY)
//    private List<Reviews> reviews;
//}
