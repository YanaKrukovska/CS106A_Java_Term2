package ua.edu.ukma.ykrukovska.lab2;

import java.util.*;

public class Storage implements WareService {


    private List<Ware> wares = new LinkedList();
    private Set<String> groups = new TreeSet<>();


    @Override
    public Ware addWare(Ware ware) {


        Iterator<Ware> iterator = wares.iterator();
        boolean isAlreadyIn = false;

        while (iterator.hasNext()) {
            Ware wareNext = iterator.next();
            if (ware.getName().equals(wareNext.getName())) {
                isAlreadyIn = true;
                break;
            }
        }
        if (!isAlreadyIn) {
            wares.add(ware);
            groups.add(ware.getGroup());
        }
        return ware;
    }

    @Override
    public Ware editWare(Ware editedWare) {

        Ware oldWare = getByName(editedWare.getName());
        if (oldWare != null) {

            wares.remove(oldWare);
            wares.add(editedWare);

            return editedWare;
        }
        return null;
    }

    @Override
    public Ware getByName(String name) {
        Iterator<Ware> iterator = wares.iterator();

        while (iterator.hasNext()) {
            Ware wareNext = iterator.next();
            if (name.equals(wareNext.getName())) {
                return wareNext;
            }
        }
        return null;
    }

    @Override
    public List<Ware> listWares() {

        return wares;
    }

    @Override
    public void deleteWareByName(String name) {

        Ware ware = getByName(name);
        if (ware != null) {

            wares.remove(ware);

        }
    }

    @Override
    public String addGroup(String groupName) {
        groups.add(groupName);
        return groupName;
    }

    @Override
    public Set<String> getGroups() {
        return groups;
    }

    @Override
    public String editGroup(String groupName, String newName) {

        Iterator<Ware> iterator = wares.iterator();

        while (iterator.hasNext()) {
            Ware wareNext = iterator.next();
            if (wareNext.getGroup().equals(groupName)) {
                wareNext.setGroup(newName);
            }
        }
        groups.remove(groupName);
        groups.add(newName);
        return newName;


    }

    @Override
    public void deleteGroup(String groupName) {
        if (groups.contains(groupName)) {

            Iterator<Ware> iterator = wares.iterator();

            while (iterator.hasNext()) {
                Ware wareNext = iterator.next();
                if (wareNext.getGroup().equals(groupName)) {
                    iterator.remove();
                }
            }
            groups.remove(groupName);
        }
    }

    @Override
    public List<Ware> listGroupWares(String groupName) {
        List<Ware> groupItems = new LinkedList<>();
        if (groups.contains(groupName)) {

            Iterator<Ware> iterator = wares.iterator();

            while (iterator.hasNext()) {
                Ware wareNext = iterator.next();
                if (wareNext.getGroup().equals(groupName)) {
                    groupItems.add(wareNext);
                }
            }

        }

        return groupItems;
    }

    @Override
    public String showInformation(List<Ware> wares) {

        StringBuilder sb = new StringBuilder("Statistics");
        sb.append("Ware amount: ").append(wares.size()).append(System.lineSeparator());
        Iterator<Ware> iterator = wares.iterator();

        while (iterator.hasNext()) {
            Ware wareNext = iterator.next();
            sb.append(wareNext.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public String showGroupWaresInformation(List<Ware> wares) {

        StringBuilder sb = new StringBuilder("Group statistics");
        sb.append("Ware amount: ").append(wares.size()).append(System.lineSeparator());
        Iterator<Ware> iterator = wares.iterator();

        while (iterator.hasNext()) {
            Ware wareNext = iterator.next();
            sb.append(wareNext.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public String showOverallPrice(List<Ware> wares) {
        StringBuilder sb = new StringBuilder("Overall price");
        sb.append("Ware amount: ").append(wares.size()).append(System.lineSeparator());
        Iterator<Ware> iterator = wares.iterator();

        double price = 0;
        while (iterator.hasNext()) {
            Ware wareNext = iterator.next();
            price += wareNext.getPrice() * wareNext.getAmount();
        }
        sb.append("Overall price: ").append(price).append(System.lineSeparator());

        return sb.toString();
    }



    public List<Ware> getWares() {
        return wares;
    }
}
