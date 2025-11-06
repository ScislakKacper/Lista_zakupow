# Lista_zakupow
Najważniejszy projekt do nauki działania ListView i ArrayAdapter!
Aby utworzyć poprawnie funkcjonujące ListView należy:
1. Dodać element ListView do widoku w activity_main.xml
2. Pobrać ten element w MainActivity.java

ListView listview = findViewById(R.id.listview)

4. Tworzymy listę przechowującą nasze elementy

ArrayList<TypListy*> listaElementowListView = new ArrayList<>();

5. Tworzymy ArrayAdapter pozwalający nam wyświetlić dane ArrayList w postaci itemów ListView

ArrayAdapter<TypArrayAdaptera*> arrayadapter =new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, listaElementowListView);

* Uwaga!!! ArrayList i ArrayAdapter muszą mieć ten sam typ
5. Podpinamy naszego ArrayAdaptera do ListView

listview.setAdapter(arrayadapter);

6. Nasze elementy ArrayList będą teraz wyświetlane jako elementy ListView
7. Jeżeli przeprowadzamy modyfikacje na naszej ArrayList (np. usuwanie elementów lub zmiana ich wartości), musimy aktualizować ArrayAdapter by poprawnie wyświetlać ListView

arrayAdapter.notifyDataSetChanged();
