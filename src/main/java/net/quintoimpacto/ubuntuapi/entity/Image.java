package net.quintoimpacto.ubuntuapi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String publicId;

    @Column(nullable = false)
    private String url;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = true)
    private String tags;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "micro_business_id")
    private MicroBusiness microBusiness;

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", publicId='" + publicId + '\'' +
                ", url='" + url + '\'' +
                ", createdAt=" + createdAt +
                ", tags='" + tags + '\'' +
                ", microBusiness=" + microBusiness +
                '}';
    }
}
