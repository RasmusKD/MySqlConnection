public class Main {
    public static void main(String[] args) {
        try {
            DbSql dbSql = new DbSql();
            UseCase useCase = new UseCase(dbSql);
            Studerende studerende = useCase.hentStamoplysninger(1);
            System.out.println(studerende);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
