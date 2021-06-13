package vnu.uet.trainingpoint.model;

public enum ExamDiscipline { // kỷ luật thi

    NO, DINH_CHI, CANH_CAO, KHIEN_TRACH;

    public static ExamDiscipline convertToEnum(String str) {
        for (ExamDiscipline e : ExamDiscipline.values()) {
            if (str.equals(e.toString())) {
                return e;
            }
        }
        return NO;
    }
}
