import java.util.Date;

public class Order {
    private int idOrder;
    private Produs prod;
    private User usr;
    private int pret;
    private Date data;
    private String status;


    public Order(int idOrder, Produs prod, User usr, int pret, Date data, String status) {
        this.idOrder = idOrder;
        this.prod = prod;
        this.usr = usr;
        this.pret = pret;
        this.data = data;
        this.status = status;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public Produs getProd() {
        return prod;
    }

    public User getUsr() {
        return usr;
    }

    public int getPret() {
        return pret;
    }

    public Date getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }
}
