package ma.amine.service;

public class SecurityContext {
    private static String username = "";
    private static String password = "";
    private static String[] roles = {};

    public static void authenticate(String u, String p, String[] r) {
        //pour vérifier les informations d'authentification
        if (u.equals("root") && p.equals("1234")) {
            //pour stocker les informations d'authentification
            username = u;
            password = p;
            roles = r;
        } else {
            throw new RuntimeException("Access Denied");
        }
    }
//pour vérifier si l'utilisateur courant a un rôle donné
    public static boolean hasRole(String r) {
        //
        for (String role : roles) {
            //
            if (r.equals(r)) return true;
//
        }

        return false;
    }
}