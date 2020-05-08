package fundamentals.passbyvalue;

public class Main {


    public static void main(String[] args) {
        Reference ref = new Reference(1);

        System.out.println("Hash of initial before passing: " + ref.hashCode());
        System.out.println("Field val of initial before passing: " + ref.getVal());

        Reference changed = change(ref);

        System.out.println("Hash of initial after passing: " + ref.hashCode());
        System.out.println("Field val of initial after passing: " + ref.getVal());
        System.out.println("Hash of changed: " + changed.hashCode());
        System.out.println("Field val of changed: " + changed.getVal());
    }

    private static Reference change(Reference ref) {
        ref.setVal(2);
        ref = new Reference(3);
        ref.setVal(4);
        return ref;
    }

    private static class Reference {
        private Integer val;

        public Reference(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }
    }
}
