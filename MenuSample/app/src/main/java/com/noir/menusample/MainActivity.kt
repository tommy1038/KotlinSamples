package com.noir.menusample

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  // リストビューに表示するリストデータ
  private var _menuList: MutableList<MutableMap<String, Any>>? = null
  // SimpleAdapterの第4引数fromに使用する定数フィールド
  private val FROM = arrayOf("name", "price")
  // SimpleAdapterの第5引数toに使用する定数フィールド
  private val TO = intArrayOf(R.id.tvMenuName, R.id.tvMenuPrice)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    // 定食メニューListオブジェクトをprivateメソッドを利用して用意し，フィールドに格納
    _menuList = createTeishokuList()
    // 画面部品ListViewを取得
    val lvMenu = findViewById<ListView>(R.id.lvMenu)
    // SimpleAdapterを生成
    val adapter = SimpleAdapter(applicationContext, _menuList, R.layout.row, FROM, TO)
    // アダプタの登録
    lvMenu.adapter = adapter
    // リストタップのリスナクラス登録
    lvMenu.onItemClickListener = ListItemClickListener()
  }

  // リストがタップされた時の処理が記述されたメンバクラス
  private inner class ListItemClickListener : AdapterView.OnItemClickListener {
    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
      // タップされた行のデータを取得．
      // SimpleAdapterでは1行分のデータはMutableMap型
      val item = parent.getItemAtPosition(position) as MutableMap<String, Any>
      // 定食名と金額を取得
      val menuName = item["name"] as String
      val menuPrice = item["price"] as Int
      // インテントオブジェクトを生成
      val intent = Intent(applicationContext, MenuThanksActivity::class.java)
      // 第2画面に送るデータを格納
      intent.putExtra("menuName", menuName)
      intent.putExtra("menuPrice", "${menuPrice}円")
      // 第2画面の起動
      startActivity(intent)
    }
  }

  private fun createTeishokuList(): MutableList<MutableMap<String, Any>> {
    // 定食メニューリスト用のListオブジェクトを用意
    val menuList: MutableList<MutableMap<String, Any>> = mutableListOf()
    //「から揚げ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録。
    var menu =
      mutableMapOf(
        "name" to "から揚げ定食",
        "price" to 800,
        "desc" to "若鳥のから揚げにサラダ、ご飯とお味噌汁が付きます。"
      )
    menuList.add(menu)
    //「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録。
    menu = mutableMapOf(
      "name" to "ハンバーグ定食",
      "price" to 850,
      "desc" to "手ごねハンバーグにサラダ、ご飯とお味噌汁が付きます。"
    )
    menuList.add(menu)
    //以下データ登録の繰り返し。
    menu = mutableMapOf(
      "name" to "生姜焼き定食",
      "price" to 850,
      "desc" to "すりおろし生姜を使った生姜焼きにサラダ、ご飯とお味噌汁が付きます。"
    )
    menuList.add(menu)
    menu = mutableMapOf(
      "name" to "ステーキ定食",
      "price" to 1000,
      "desc" to "国産牛のステーキにサラダ、ご飯とお味噌汁が付きます。"
    )
    menuList.add(menu)
    menu = mutableMapOf(
      "name" to "野菜炒め定食",
      "price" to 750,
      "desc" to "季節の野菜炒めにサラダ、ご飯とお味噌汁が付きます。"
    )
    menuList.add(menu)
    menu = mutableMapOf(
      "name" to "とんかつ定食",
      "price" to 900,
      "desc" to "ロースとんかつにサラダ、ご飯とお味噌汁が付きます。"
    )
    menuList.add(menu)
    menu = mutableMapOf(
      "name" to "ミンチかつ定食",
      "price" to 850,
      "desc" to "手ごねミンチカツにサラダ、ご飯とお味噌汁が付きます。"
    )
    menuList.add(menu)
    menu = mutableMapOf(
      "name" to "チキンカツ定食",
      "price" to 900,
      "desc" to "ボリュームたっぷりチキンカツにサラダ、ご飯とお味噌汁が付きます。"
    )
    menuList.add(menu)
    menu =
      mutableMapOf(
        "name" to "コロッケ定食",
        "price" to 850,
        "desc" to "北海道ポテトコロッケにサラダ、ご飯とお味噌汁が付きます。"
      )
    menuList.add(menu)
    menu = mutableMapOf(
      "name" to "焼き魚定食",
      "price" to 850,
      "desc" to "鰆の塩焼きにサラダ、ご飯とお味噌汁が付きます。"
    )
    menuList.add(menu)
    menu = mutableMapOf(
      "name" to "焼肉定食",
      "price" to 950,
      "desc" to "特性たれの焼肉にサラダ、ご飯とお味噌汁が付きます。"
    )
    menuList.add(menu)
    return menuList
  }
}
