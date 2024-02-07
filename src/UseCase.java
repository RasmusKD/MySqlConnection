public class UseCase {
    private DbSql dbSql;

    public UseCase(DbSql dbSql) {
        this.dbSql = dbSql;
    }

    public Studerende hentStamoplysninger(int stdnr) throws Exception {
        return dbSql.hentStamoplysninger(stdnr);
    }
}
