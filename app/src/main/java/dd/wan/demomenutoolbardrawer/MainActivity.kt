package dd.wan.demomenutoolbardrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar as Toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        btn_popMenu.setOnClickListener {
            var popupMenu = PopupMenu(this, it)
            popupMenu.menuInflater.inflate(R.menu.menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                selectedItemMenu(it.itemId)
                false
            }
            popupMenu.show()
        }
        registerForContextMenu(contextMenu)
        menuDrawer.setOnClickListener { drawerLayout.openDrawer(GravityCompat.START) }
        navigationView.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.itemHome -> {Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show()}
                R.id.itemEmail -> {Toast.makeText(this,"Email",Toast.LENGTH_SHORT).show()}
                R.id.itemHelp -> {Toast.makeText(this,"Help",Toast.LENGTH_SHORT).show()}
                R.id.itemShare -> {Toast.makeText(this,"Share",Toast.LENGTH_SHORT).show()}
                R.id.itemSend -> {Toast.makeText(this,"Send",Toast.LENGTH_SHORT).show()}
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.menu,menu)
        menu?.setHeaderTitle("Context Menu")
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        selectedItemMenu(item.itemId)
        return super.onContextItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        selectedItemMenu(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    fun selectedItemMenu(id: Int) {
        when (id) {
            R.id.item1 -> {
                Toast.makeText(this, "Home Selected", Toast.LENGTH_SHORT).show()
            }
            R.id.item2 -> {
                Toast.makeText(this, "Profile Selected", Toast.LENGTH_SHORT).show()
            }
            R.id.item3 -> {
                Toast.makeText(this, "Option Selected", Toast.LENGTH_SHORT).show()
            }
            R.id.item4 -> {
                Toast.makeText(this, "Hold context menu button", Toast.LENGTH_SHORT).show()
            }
            R.id.subitem1 -> {
                Toast.makeText(this, "Option 1", Toast.LENGTH_SHORT).show()
            }
            R.id.subitem2 -> {
                Toast.makeText(this, "Option 2", Toast.LENGTH_SHORT).show()
            }
            R.id.subitem3 -> {
                Toast.makeText(this, "Option 3", Toast.LENGTH_SHORT).show()
            }
        }
    }
}