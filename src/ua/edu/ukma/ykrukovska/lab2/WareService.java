package ua.edu.ukma.ykrukovska.lab2;

import java.util.List;
import java.util.Set;

public interface WareService {

    Ware addWare(Ware ware);

    Ware editWare(Ware ware);

    Ware getByName(String name);

    List<Ware> listWares();

    void deleteWareByName(String name);

    String addGroup(String groupName);

    Set<String> getGroups();

    String editGroup(String groupName, String newName);

    void deleteGroup(String groupName);

    List<Ware> listGroupWares(String groupName);

    String showInformation(List<Ware> wares);
    String showGroupWaresInformation(List<Ware> wares);

    String showOverallPrice(List<Ware> wares);

}
