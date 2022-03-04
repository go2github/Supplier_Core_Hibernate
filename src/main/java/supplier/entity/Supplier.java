package supplier.entity;

import javax.persistence.*;

@Entity
@Table(name = "supplier")
@NamedQuery(name = "Supplier_By_Id",query = "from Supplier where supplier_Id=:id")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplier_Id;

    private String company_name;

    private String address;

    private String country;

    public Supplier() {
    }

    public Long getSupplier_Id() {
        return supplier_Id;
    }

    public void setSupplier_Id(Long supplier_Id) {
        this.supplier_Id = supplier_Id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
