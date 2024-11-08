package cleanArchitecture.notes.infrastructure.persistance;

public abstract class DbContext {
    protected  Database database;

    public DbContext(Database database) {
        this.database = database;
    }
    public  abstract void onModelCreating(ModelBuilder builder);
    public boolean saveChanges(){
        //todo: сохранение изменений в бд
        return true;
    }


}

class ModelBuilder {
    public ModelBuilder applyConfiguration(ModelConfiguration configuration){
        //todo: добавление конфигурации маппинга объекта некоторого типа к стуктуре таблицы БД
        return this;
    }
}
