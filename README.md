# TAA - TP3 (Partie 3)

### Architecture du projets
L'architecture du projet est similaire à celle des tp1 et tp2 pour la majeure partie, seul
l'ajout d'un package Web permettant de définir les points d'accès web à l'API a été ajouté.

### Exécution du projet
1. Pour ce projet comme pour les projets 1 et 2 il faut exécuter la base de données hsqldb
2. Puis exécuter la classe java SampleDataJpaApplication.java

### Utilisation
Ce projet couvre lui aussi uniquement l'api pour la classe métier Employee ses points d'accès sont:
- http://localhost:8080/employee/create qui permet de créer un nouvel employé en utilisant une méthode post.
(ex: http://localhost:8080/employee/create?firstName=bob&lastName=Dylan ajoutera un employé s'appelant Bob Dylan))
- http://localhost:8080/employee/register qui permet d'ajouter un nouvel employé à l'aide d'un formulaire
- http://localhost:8080/employee/delete qui permet de supprimer un employé en utilisante une méthode post.
- http://localhost:8080/employee/list qui permet de lister tous les employés du système
- http://localhost:8080/employee/{id}/ qui permet de retrouver un employee par son identifiants
- http://localhost:8080/employee/{id}/tasks et http://localhost:8080/employee/{id}/projects qui permettent
respectivement de retrouver les tâches et les projets dans lequel l'employé d'identifiant {id} participe
