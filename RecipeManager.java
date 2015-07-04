public class RecipeManager {

    public static void main(String[] args) {
        //レシピをひとつ用意して
        Recipe recipe = new Recipe("Omelet Rice");
        //レシピ名を出力する
        System.out.println(recipe.getTitle());
    }
}
