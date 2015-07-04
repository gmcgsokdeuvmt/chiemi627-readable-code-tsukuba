import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RecipeManager {

    ArrayList<Recipe> recipeList;
    String recipefile = "recipe-data.csv";

    public RecipeManager(){
        this.recipeList = new ArrayList<Recipe>();
    }

    //レシピをひとつ追加する
    public void addRecipe(Recipe recipe){
        this.recipeList.add(recipe);
    }
    //レシピ数を出力する
    public int countRecipes(){
        return this.recipeList.size();
    }
    //i番目のレシピを出力する
    public Recipe getRecipe(int i){
        return this.recipeList.get(i);
    }

    //レシピリストをファイルから読み込む
    public void loadRecipesFromFile(){
        try {
            File file = new File(this.recipefile);
            FileReader filereader = new FileReader(file);
            BufferedReader br = new BufferedReader(filereader);
            String line;
            while ((line = br.readLine()) != null) {
                //行ごとの処理はRecipeクラスで行っています
                Recipe recipe = Recipe.makeRecipeFromCSV(line);
                this.addRecipe(recipe);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("Recipe file can not be found.: "+recipefile);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //main引数：　第一引数にレシピファイル名
    public static void main(String[] args) {
        //レシピマネージャーを用意
        RecipeManager manager = new RecipeManager();
        //レシピファイルからデータをロード
        manager.loadRecipesFromFile();
        //レシピ名を出力する
        for(int i=0;i<manager.countRecipes();i++){
            Recipe rcp = manager.getRecipe(i);
            System.out.println(rcp.getTitle());
        }
    }
}