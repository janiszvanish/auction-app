package pl.edu.pjwstk.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "contact_info")
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "area_code", unique = true)
    private String areaCode;
    @Column(name = "mobile_phone", unique = true)
    private String mobilePhone;
    @Column(name = "landline_phone", unique = true)
    private String landlinePhone;
    @Column(name = "email", unique = true)
    private String email;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}
