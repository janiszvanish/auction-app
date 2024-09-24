package pl.edu.pjwstk.entities;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "street_number")
    private String streetNumber;
    @Column(name = "flat_number")
    private String flatNumber;
    @Column(name = "postal_code")
    private String postalCode;
    private String city;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
