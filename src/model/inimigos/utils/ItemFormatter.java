package model.inimigos.utils;


import model.itens.Itens;
import java.util.List;

public class ItemFormatter {
    public static String formatarInventario(List<Itens> inventario) {
        if (inventario == null || inventario.isEmpty()) {
            return "Nenhum item";
        }

        StringBuilder atributos = new StringBuilder();
        for (int i = 0; i < inventario.size(); i++) {
            Itens item = inventario.get(i);
            atributos.append(item.getNome()).append(";")
                    .append(item.getTipo()).append(";")
                    .append(item.isPodeUsarEmCombate() ? "1" : "0").append(";")
                    .append(item.getBonusFA()).append(";")
                    .append(item.getBonusDano());

            if (i < inventario.size() - 1) {
                atributos.append(" | ");
            }
        }
        return atributos.toString();
    }
}
