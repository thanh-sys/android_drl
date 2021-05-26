package vnu.uet.trainingpoint.model;

public enum Status {

    NEED_STUDENT_FILL, // cần sinh viên điền phiếu
    PENDING_APPROVAL_OF_CLASS_PRESIDENT, // chờ phê duyệt của lớp trưởng
    PENDING_APPROVAL_OF_CONSULTANT, //chờ phê duyệt của cố vấn học tập
    SUCCESS, // đã phê duyệt
    FAIL;// bị phê duyệt là k đạt -> 0 điểm

    public static Status convertToEnum(String str){
        for(Status s: Status.values()){
            if(str.equals(s.toString())){
                return s;
            }
        }
        return NEED_STUDENT_FILL;
    }
}
