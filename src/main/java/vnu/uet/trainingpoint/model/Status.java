package vnu.uet.trainingpoint.model;

public enum Status {

    NEED_STUDENT_FILL("Sinh viên chưa điền phiếu"), // cần sinh viên điền phiếu
    PENDING_APPROVAL_OF_CLASS_PRESIDENT("Chờ lớp trưởng duyệt"), // chờ phê duyệt của lớp trưởng
    PENDING_APPROVAL_OF_CONSULTANT("Chờ cố vấn học tập phê duyệt"), //chờ phê duyệt của cố vấn học tập
    SUCCESS("Đã phê duyệt"), // đã phê duyệt
    FAIL("Phê duyệt thất bại");// bị phê duyệt là k đạt -> 0 điểm

    private String s;

    Status(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public static String getString(Status status) {
        for (Status s : Status.values()) {
            if (s.equals(status)) {
                return s.getS();
            }
        }
        return NEED_STUDENT_FILL.getS();
    }

    public static Status convertToEnum(String str) {
        for (Status s : Status.values()) {
            if (str.equals(s.toString())) {
                return s;
            }
        }
        return NEED_STUDENT_FILL;
    }
}
