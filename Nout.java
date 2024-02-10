public class Nout {
    String brend;
    int ozu;
    int valueGD;
    String os;

    @Override
    public String toString() {
        return "brend: " + brend + ", ozu: " + ozu + ", valueGD: " + valueGD + ", os: " + os;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Nout)){
            return false;
        }
        Nout nout = (Nout) obj;
        return brend.equals(nout.brend) && ozu == nout.ozu && valueGD == nout.valueGD && os.equals(nout.os);
    }

    @Override
    public int hashCode() {
        return brend.hashCode() + 7*ozu + 13*valueGD + 17*os.hashCode();

    
    }

}
