/**
 * Created by chiemi on 2015/07/04.
 */
public class Recipe {
    public String title;

    public Recipe(){}
    public Recipe(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public static Recipe makeRecipeFromCSV(String line){
        //Recipeオブジェクトを作る
        Recipe recipe = new Recipe();
        //CSVファイルからRecipeデータを作る
        String[] items = line.split(",");

        //とりあえず最初は0番目にタイトル
        //TODO: フォーマットの変化に対応できるようにする
        recipe.title = items[0];

        return recipe;

    }
}
