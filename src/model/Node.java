package Assignment.model;

public class Node {
    private String key;
    private String parent;
    private double dm, da, de, em, ea, ee, h, s;

    public Node(String key, String parent) {
        if(key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        this.key = key;
        this.parent = parent;
    }

    public void setdm(double indm) {
        this.dm = indm;
    }

    public void setda(double inda) {
        this.da = inda;
    }

    public void setde(double inde) {
        this.de = inde;
    }

    public void setem(double inem) {
        this.em = inem;
    }

    public void setea(double inea) {
        this.ea = inea;
    }

    public void setee(double inee) {
        this.ee = inee;
    }

    public void seth(double inH) {
        this.h = inH;
    }

    public void sets(double inS) {
        this.s = inS;
    }

    public double getdm() {
        return this.dm;
    }

    public double getda() {
        return this.da;
    }

    public double getde() {
        return this.de;
    }

    public double getem() {
        return this.em;
    }

    public double getea() {
        return this.ea;
    }

    public double getee() {
        return this.ee;
    }

    public double geth() {
        return this.h;
    }

    public double gets() {
        return this.s;
    }

    public String getKey() {
        return this.key;
    }

    public String getParent() {
        return this.parent;
    }
}
