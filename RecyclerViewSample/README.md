# RecyclerViewSample
Demo app for RecyclerView in Android

```
implementation 'com.android.support:recyclerview-v7:28.0.0-rc02'
```

### Steps 

1. Add RecyclerView in activity_main
2. Design single row of your RecyclerView in a sepearte XML file
3. Create your model class (Player)
4. Create custom ViewHolder (PlayerViewHolder) class by extending RecyclerView.ViewHolder
5. Create custom ViewAdapter (PlayerViewAdapater) class by extending RecyclerView.Adapter<PlayerViewHolder>
6. Prepare list of Player class
7. Initialise RecyclerView with LayoutManager & pass Player list prepared in step 6

### activity_main.xml

**Add RecyclerView in activity_main**

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:showIn="@layout/activity_main">

    <android.support.v7.widget.RecyclerView
        android:id="@+id/recycler_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:scrollbars="vertical"/>

</RelativeLayout>
```

### my_list_view.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="wrap_content">

    <ImageView
        android:id="@+id/img1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@mipmap/ic_launcher_round"
        android:paddingTop="30dp"
        android:paddingLeft="20dp"/>

    <TextView
        android:id="@+id/name"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_toRightOf="@id/img1"
        android:paddingTop="20dp"
        android:paddingLeft="30dp"
        android:text="Name"
        android:textSize="40sp"/>

    <TextView
        android:id="@+id/battingStyle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_toRightOf="@id/img1"
        android:layout_below="@id/name"
        android:paddingLeft="30dp"
        android:text="battingStyle"
        android:textSize="20sp"/>

</RelativeLayout>
```

### Student.java

```java
public class Player {

    String name;
    String battingStyle;


    public Player(String name, String battingStyle) {
        this.name = name;
        this.battingStyle = battingStyle;
    }
}
```

### View holder will hold the design for every single item in RecyclerView

### Create a ViewHolder - PlayerViewHolder.java

```java
public class PlayerViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView name;
    TextView battingStyle;

    public PlayerViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.img1);
        name = itemView.findViewById(R.id.name);
        battingStyle = itemView.findViewById(R.id.battingStyle);
    }
}
```

### View Adapter will be responsible for rendering each line in RecyclerView

### PlayerViewAdapater.java

```java
public class PlayerViewAdapater extends RecyclerView.Adapter<PlayerViewHolder> {

    List<Player> playerList;
    Context context;

    PlayerViewAdapater(Context context, List<Player> players){
        this.playerList = players;
        this.context = context;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_list_item, viewGroup, false);
        PlayerViewHolder playerViewHolder = new PlayerViewHolder(view);
        return playerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder playerViewHolder, int i) {

        playerViewHolder.imageView.setImageResource(R.mipmap.ic_launcher_round);
        playerViewHolder.name.setText(playerList.get(i).name);
        playerViewHolder.battingStyle.setText(playerList.get(i).battingStyle);
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }
}
```

### MainActivity.java

```java
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);

        Player s1 = new Player("S Dhawan", "L Batsman");
        Player s2 = new Player("R Sharma", "R Batsman");
        Player s3 = new Player("V Kohli", "R Batsman");
        Player s4 = new Player("KL Rahul", "R Batsman");
        Player s5 = new Player("S Raina", "L Batsman");
        Player s6 = new Player("MS Dhoni", "R Batsman");
        Player s7 = new Player("H Pandya", "R Batsman");
        Player s8 = new Player("U Yadav", "R Batsman");
        Player s9 = new Player("K Yadav", "L Batsman");
        Player s10 = new Player("I Sharma", "R Batsman");
        Player s11 = new Player("J Bumrah", "R Batsman");

        List<Player> playerList = new ArrayList<>();
        playerList.add(s1);
        playerList.add(s2);
        playerList.add(s3);
        playerList.add(s4);
        playerList.add(s5);
        playerList.add(s6);
        playerList.add(s7);
        playerList.add(s8);

        PlayerViewAdapater playerViewAdapater = new PlayerViewAdapater(this, playerList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(playerViewAdapater);
    }
}
```
<img src="https://image.ibb.co/ecb2Nz/Screenshot_1535740388.png" alt="RecyclerView_Sample" width="300"/>

