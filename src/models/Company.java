package models;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "company")
@NamedQueries({
    @NamedQuery(
            name = "getAllCompanys",
            query = "SELECT c FROM Company AS c ORDER BY c.id DESC"
            ),
    @NamedQuery(
            name = "getCompanysCount",
            query = "SELECT COUNT(c) FROM Company AS c"
            ),
})
@Entity
public class Company {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "contract_date", nullable = false)
    private Date contract_date;

    @Column(name = "company_name", length = 255, nullable = false)
    private String company_name;

    @Column(name = "president", nullable = false)
    private String president;

    @Column(name = "tellnumber", nullable = false)
    private String tellnumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getContract_date() {
        return contract_date;
    }

    public void setContract_date(Date contract_date) {
        this.contract_date = contract_date;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getTellnumber() {
        return tellnumber;
    }

    public void setTellnumber(String tellnumber) {
        this.tellnumber = tellnumber;
    }
}
