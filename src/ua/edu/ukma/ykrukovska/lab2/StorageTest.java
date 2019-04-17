package ua.edu.ukma.ykrukovska.lab2;

import org.junit.Assert;
import org.junit.Test;

public class StorageTest {

    @Test
    public void add1Ware() {

        Storage storage = new Storage();
        storage.addWare(new Ware("Purina One", "cat food", "Purina", 200, "Pet food"));
        Assert.assertEquals(1, storage.listWares().size());

    }

    @Test
    public void addDuplicatedWare() {

        Storage storage = new Storage();
        storage.addWare(new Ware("Purina One", "cat food", "Purina", 200, "Pet food"));
        storage.addWare(new Ware("Purina One", "cat food", "Purina", 200, "Pet food"));
        Assert.assertEquals(1, storage.listWares().size());

    }

    @Test
    public void getByName() {

        Storage storage = new Storage();
        storage.addWare(new Ware("Purina One", "cat food", "Purina", 200, "Pet food"));

        Assert.assertNotNull(storage.getByName("Purina One"));

    }

    @Test
    public void getByNameNotFound() {

        Storage storage = new Storage();
        storage.addWare(new Ware("Purina One", "cat food", "Purina", 200, "Pet food"));

        Assert.assertNull(storage.getByName("Purina Two"));

    }

    @Test
    public void editWare() {

        Storage storage = new Storage();
        storage.addWare(new Ware("Purina One", "cat food", "Purina", 200, "Pet food"));
        storage.editWare(new Ware("Purina One", "premium cat food", "Purina GMBH", 300, "Pet food"));

        Assert.assertEquals("premium cat food", storage.getByName("Purina One").getDescription());

    }

    @Test
    public void deleteWare() {

        Storage storage = new Storage();
        storage.addWare(new Ware("Purina Two", "cat food", "Purina", 200, "Pet food"));
        storage.addWare(new Ware("Purina One", "premium cat food", "Purina GMBH", 300, "Pet food"));

        storage.deleteWareByName("Purina One");
        Assert.assertEquals(1, storage.listWares().size());
        Assert.assertEquals("Purina Two", storage.getByName("Purina Two").getName());

    }

    @Test
    public void editGroup() {

        Storage storage = new Storage();
        storage.addWare(new Ware("Purina One", "cat food", "Purina", 200, "Pet food"));
        storage.addWare(new Ware("Purina Two", "premium cat food", "Purina GMBH", 300, "Pet food"));
        storage.addWare(new Ware("Yoghurt", "premium human food", "ONUR", 70, "Human food"));
        storage.editGroup("Human food", "Food");
        Assert.assertEquals("Food", storage.getByName("Yoghurt").getGroup());
        Assert.assertTrue(storage.getGroups().contains("Food"));
        Assert.assertFalse(storage.getGroups().contains("Human food"));

    }

    @Test
    public void deleteGroup() {

        Storage storage = new Storage();
        storage.addWare(new Ware("Purina One", "cat food", "Purina", 200, "Pet food"));
        storage.addWare(new Ware("Kefir", "premium human food", "ONUR", 70, "Human food"));
        storage.addWare(new Ware("Koperek", "food of gods", "God", 1000000, "God food"));
        storage.addWare(new Ware("Purina Two", "premium cat food", "Purina GMBH", 300, "Pet food"));
        storage.addWare(new Ware("Yoghurt", "premium human food", "ONUR", 70, "Human food"));

        storage.deleteGroup("Pet food");
        storage.deleteGroup("Food");
        Assert.assertFalse( storage.getGroups().contains("Pet food"));
        Assert.assertTrue( storage.getGroups().contains("God food"));
        Assert.assertEquals(2, storage.getGroups().size());

    }

    @Test
    public void listGroupItems() {

        Storage storage = new Storage();
        storage.addWare(new Ware("Purina One", "cat food", "Purina", 200, "Pet food"));
        storage.addWare(new Ware("Kefir", "premium human food", "ONUR", 70, "Human food"));
        storage.addWare(new Ware("Koperek", "food of gods", "God", 1000000, "God food"));
        storage.addWare(new Ware("Purina Two", "premium cat food", "Purina GMBH", 300, "Pet food"));
        storage.addWare(new Ware("Purina Three", "Super premium cat food", "Purina GMBH", 300, "Pet food"));
        storage.addWare(new Ware("Yoghurt", "premium human food", "ONUR", 70, "Human food"));


        Assert.assertEquals(3, storage.listGroupWares("Pet food").size());
        Assert.assertEquals("Pet food", storage.listGroupWares("Pet food").get(0).getGroup());
        Assert.assertEquals("Pet food", storage.listGroupWares("Pet food").get(1).getGroup());
        Assert.assertEquals("Pet food", storage.listGroupWares("Pet food").get(2).getGroup());

    }

    @Test
    public void showAllWaresInformation() {

        Storage storage = new Storage();
        storage.addWare(new Ware("Purina One", "cat food", "Purina", 200, "Pet food"));
        storage.addWare(new Ware("Kefir", "premium human food", "ONUR", 70, "Human food"));
        storage.addWare(new Ware("Koperek", "food of gods", "God", 1000000, "God food"));
        storage.addWare(new Ware("Purina Two", "premium cat food", "Purina GMBH", 300, "Pet food"));
        storage.addWare(new Ware("Purina Three", "Super premium cat food", "Purina GMBH", 300, "Pet food"));
        storage.addWare(new Ware("Yoghurt", "premium human food", "ONUR", 70, "Human food"));

        System.out.println(storage.showInformation(storage.getWares()));

    }

    @Test
    public void showGroupWaresInformation() {

        Storage storage = new Storage();
        storage.addWare(new Ware("Purina One", "cat food", "Purina", 20, "Pet food"));
        storage.addWare(new Ware("Kefir", "premium human food", "ONUR", 70, "Human food"));
        storage.addWare(new Ware("Koperek", "food of gods", "God", 10, "God food"));
        storage.addWare(new Ware("Purina Two", "premium cat food", "Purina GMBH", 30, "Pet food"));
        storage.addWare(new Ware("Purina Three", "Super premium cat food", "Purina GMBH", 30, "Pet food"));
        storage.addWare(new Ware("Yoghurt", "premium human food", "ONUR", 70, "Human food"));

        System.out.println(storage.showGroupWaresInformation(storage.listGroupWares("Human food")));

    }

    @Test
    public void showOverallPrice() {

        Storage storage = new Storage();
        storage.addWare(new Ware("Purina One", "cat food", "Purina", 20, "Pet food"));
        storage.addWare(new Ware("Kefir", "premium human food", "ONUR", 70, "Human food"));
        storage.addWare(new Ware("Koperek", "food of gods", "God", 100, "God food"));
        storage.addWare(new Ware("Purina Two", "premium cat food", "Purina GMBH", 30, "Pet food"));
        storage.addWare(new Ware("Purina Three", "Super premium cat food", "Purina GMBH", 30, "Pet food"));
        storage.addWare(new Ware("Yoghurt", "premium human food", "ONUR", 70, "Human food"));

        System.out.println(storage.showOverallPrice(storage.getWares()));

    }
    @Test
    public void showGroupPrice() {

        Storage storage = new Storage();
        storage.addWare(new Ware("Purina One", "cat food", "Purina", 20, "Pet food"));
        storage.addWare(new Ware("Kefir", "premium human food", "ONUR", 70, "Human food"));
        storage.addWare(new Ware("Purina Two", "premium cat food", "Purina GMBH", 30, "Pet food"));
        storage.addWare(new Ware("Koperek", "food of gods", "God", 100, "God food"));
        storage.addWare(new Ware("Purina Three", "Super premium cat food", "Purina GMBH", 30, "Pet food"));
        storage.addWare(new Ware("Yoghurt", "premium human food", "ONUR", 70, "Human food"));

        System.out.println(storage.showOverallPrice((storage.listGroupWares("Human food"))));

    }

}