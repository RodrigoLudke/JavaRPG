package model.inimigos.utils;


import model.itens.Itens;
import java.util.List;

public class ItemFormatter {
    public static String formatarInventario(List<Itens> inventario) {
        StringBuilder atributos = new StringBuilder();
        for (Itens item : inventario) {
            atributos.append(item.getNome()).append(";")
                    .append(item.getTipo()).append(";")
                    .append(item.isPodeUsarEmCombate() ? "1" : "0").append(";")
                    .append(item.getBonusFA()).append(";")
                    .append(item.getBonusDano()).append(";\n");
        }
        return atributos.toString().trim();
    }
}
