package estagioTeste.questao3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class FaturamentoDistribuidora {

    public static void main(String[] args) {
        try {
            

            
            //Caminho para acessar o Arquivo Json
            String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\mathe\\Documents\\workspace-spring-tool-suite-4-4.20.0.RELEASE\\estagioTeste\\src\\estagioTeste\\questao3\\faturamento.json")));

            JSONArray faturamentoArray = new JSONArray(content);


            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double soma = 0;
            int diasComFaturamento = 0;


            for (int i = 0; i < faturamentoArray.length(); i++) {
                JSONObject diaObj = faturamentoArray.getJSONObject(i);
                double valor = diaObj.getDouble("valor");

                if (valor > 0) {
                    if (valor < menorValor) {
                        menorValor = valor;
                    }
                    if (valor > maiorValor) {
                        maiorValor = valor;
                    }
                    soma += valor;
                    diasComFaturamento++;
                }
            }

            // Calculando a média mensal
            double mediaMensal = soma / diasComFaturamento;

            // Calculando o número de dias com faturamento superior à média mensal
            int diasAcimaDaMedia = 0;
            for (int i = 0; i < faturamentoArray.length(); i++) {
                JSONObject diaObj = faturamentoArray.getJSONObject(i);
                double valor = diaObj.getDouble("valor");

                if (valor > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Número de dias com faturamento acima da média mensal: " + diasAcimaDaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
