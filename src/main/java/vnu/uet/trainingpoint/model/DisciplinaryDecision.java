package vnu.uet.trainingpoint.model;

public enum  DisciplinaryDecision {// quyết định kỷ luật

    NO, CANH_CAO, KHIEN_TRACH,PHE_BINH;


    public static DisciplinaryDecision convertToEnum(String str){
        for(DisciplinaryDecision d: DisciplinaryDecision.values()){
            if(str.equals(d.toString())){
                return d;
            }
        }
        return NO;
    }

//    public static void main(String[] args) {
//        System.out.println(DisciplinaryDecision.getDisciplinaryDecision("NO!"));
//        System.out.println(DisciplinaryDecision.getDisciplinaryDecision("KHIEN_TRACH111"));
//        System.out.println(DisciplinaryDecision.getDisciplinaryDecision("PHE_BINH"));
//    }

}
