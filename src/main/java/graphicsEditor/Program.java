package graphicsEditor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Program {
    public static void main(String[] args) {

    }
}

class Editor3D implements  UILayer {
    private ProjectFile projectFile;
    private BusinessLogicalLayer businessLogicalLayer;
    private DatabaseAccess databaseAccessLayer;
    private Database database;


    private void initialize(){
        database = new EditorDatabase(projectFile);
        databaseAccessLayer = new EditorDatabaseAccess(database);
        businessLogicalLayer = new EditorBusinessLogicalLayer(databaseAccessLayer);
    }

    @Override
    public void openProject(String fileName) {
        this.projectFile = new ProjectFile(fileName);
        initialize();
    }

    @Override
    public void showProjectSettings() {
        checkProjectFile();

        System.out.printf("filename: %s\n", projectFile.getFileName());
        System.out.printf("setting1: %d\n", projectFile.getSetting1());
        System.out.printf("setting2: %s\n", projectFile.getSetting2());
        System.out.printf("setting3: %b\n", projectFile.isSetting3());



    }
    private void checkProjectFile() {
        if (projectFile == null ) {
            throw new RuntimeException("File not found");
        }
    }

    @Override
    public void saveProject() {
        checkProjectFile();

        database.save();
        System.out.println("Saved");
    }

    @Override
    public void printAllModels() {
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();
        for (int i = 0; i < models.size(); i++) {
            System.out.printf("==%d==\n", i);
            System.out.println(models.get(i));
            for (Texture texture: models.get(i).getTextures()) {
                System.out.printf("\t%s\n", texture);
            }
        }

    }

    @Override
    public void printAllTextures() {
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>)businessLogicalLayer.getAllTextures();
        for (int i = 0; i < textures.size(); i++) {
            System.out.printf("==%d==\n", i);
            System.out.println(textures.get(i));
        }
    }

    @Override
    public void renderAll() {
        checkProjectFile();
        System.out.println("Wait...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = System.currentTimeMillis() - startTime;
        System.out.printf("Operation completed in %d ms\n", endTime);
    }

    @Override
    public void renderMolder(int i) {
        checkProjectFile();

    }
}

interface UILayer {
    void openProject(String fileName);
    void showProjectSettings();
    void saveProject();
    void printAllModels();
    void printAllTextures();
    void renderAll();
    void renderMolder(int i);
}


class EditorBusinessLogicalLayer implements BusinessLogicalLayer {
    private final DatabaseAccess databaseAccess;

    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();

    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model : getAllModels()) {
            processRender(model);
        }
    }

    private Random random = new Random();

    private void processRender(Model3D model) {
        try {
            Thread.sleep(2500 - random.nextInt(2000));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

interface BusinessLogicalLayer {
    Collection<Model3D> getAllModels();

    Collection<Texture> getAllTextures();

    void renderModel(Model3D model);

    void renderAllModels();
}


class EditorDatabaseAccess implements DatabaseAccess {
    private final Database editorDatabase;

    public EditorDatabaseAccess(Database editorDatabase) {
        this.editorDatabase = editorDatabase;
    }

    @Override
    public void addEntity(Entity entity) {
        editorDatabase.getAll().add(entity);
    }

    @Override
    public void removeEntity(Entity entity) {
        editorDatabase.getAll().remove(entity);
    }

    @Override
    public Collection<Texture> getAllTextures() {
        Collection<Texture> textures = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Texture) {
                textures.add((Texture) entity);
            }
        }
        return textures;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        Collection<Model3D> models = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Model3D) {
                models.add((Model3D) entity);
            }
        }
        return models;
    }
}

interface DatabaseAccess {
    void addEntity(Entity entity);

    void removeEntity(Entity entity);

    Collection<Texture> getAllTextures();

    Collection<Model3D> getAllModels();
}

class EditorDatabase implements Database {
    private Random random = new Random();
    private final ProjectFile projectFile;
    private Collection<Entity> entities;

    public EditorDatabase(ProjectFile projectFile) {
        this.projectFile = projectFile;
        load();
    }

    @Override
    public void load() {
        //TODO: загрузка всех сущнностей
    }

    @Override
    public void save() {
        //TODO: сохранение текущего состояния сущностей
    }

    public Collection<Entity> getAll() {
        if (entities == null) {
            entities = new ArrayList<>();
            int entCount = random.nextInt(5, 11);
            for (int i = 0; i < entCount; i++) {
                generateModelAndTexture();
            }
        }
        return entities;
    }

    private void generateModelAndTexture() {
        Model3D model3D = new Model3D();
        int txCount = random.nextInt(3);
        for (int i = 0; i < txCount; i++) {
            Texture texture = new Texture();
            model3D.getTextures().add(texture);
            entities.add(texture);
        }
        entities.add(model3D);
    }


}

interface Database {
    void load();

    void save();

    Collection<Entity> getAll();
}


class Model3D implements Entity {
    private static int counter = 100000;

    {
    }

    private int id;
    private Collection<Texture> textures;


    public Collection<Texture> getTextures() {
        return textures;
    }

    @Override
    public int getId() {
        return id;
    }

    {
        id = ++counter;
    }

    @Override
    public String toString() {
        return String.format("3DModel #%s", id);
    }

    public Model3D() {
    }

    public Model3D(Collection<Texture> textures) {
        this.textures = textures;
    }

}

class Texture implements Entity {

    private static int counter = 50000;
    private int id;

    {
        id = ++counter;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Texture #%s", id);
    }
}

interface Entity {
    int getId();

}

class ProjectFile {
    private String fileName;
    private int setting1;
    private String setting2;
    private boolean setting3;

    public String getFileName() {
        return fileName;
    }

    public ProjectFile(String fileName) {
        //TODO: загрузка настроек проекта из файла
        this.fileName = fileName;
        setting1 = 1;
        setting2 = "setting2";
        setting3 = false;
    }

    public int getSetting1() {
        return setting1;
    }

    public String getSetting2() {
        return setting2;
    }

    public boolean isSetting3() {
        return setting3;
    }
}
