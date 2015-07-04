public class RecipeManager {

    public String getRecipeTitle() {
        String title = "Omelet Rice";
        return title;
    }

    public static void main(String[] args) {
        RecipeManager manager = new RecipeManager();
        System.out.println(manager.getRecipeTitle());
    }
}
