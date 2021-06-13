package vnu.uet.trainingpoint.model;

public enum DisciplinaryDecision {// quyết định kỷ luật

    NO, CANH_CAO, KHIEN_TRACH, PHE_BINH;


    public static DisciplinaryDecision convertToEnum(String str) {
        for (DisciplinaryDecision d : DisciplinaryDecision.values()) {
            if (str.equals(d.toString())) {
                return d;
            }
        }
        return NO;
    }
}
