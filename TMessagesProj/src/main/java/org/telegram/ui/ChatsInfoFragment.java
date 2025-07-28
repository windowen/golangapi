package org.telegram.ui;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.telegram.SQLite.SQLitePreparedStatement;
import org.telegram.messenger.AndroidUtilities;
import org.telegram.messenger.FileLog;
import org.telegram.messenger.MessagesStorage;
import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.BaseFragment;
import org.telegram9.messenger6.utils.JsonFileManager;

import android.widget.Toast;


public class ChatsInfoFragment extends BaseFragment {
    private SimpleCursorAdapter adapter;
    private ListView listView;

    @Override
    public View createView(Context context) {
        // 使用 Activity 的 LayoutInflater
        LayoutInflater inflater = LayoutInflater.from(context);
        fragmentView = inflater.inflate(R.layout.chats_info_fragment, null); // container 传 null

//        database = new ChatsInfoDatabase();

        // 初始化UI组件
        listView = fragmentView.findViewById(R.id.chats_list);
        EditText nameEditText = fragmentView.findViewById(R.id.name_edit);
        EditText nameIdEditText = fragmentView.findViewById(R.id.name_id_edit);
        EditText typeEditText = fragmentView.findViewById(R.id.type_edit);
        EditText statusEditText = fragmentView.findViewById(R.id.status_edit);
        Button addButton = fragmentView.findViewById(R.id.add_button);

        // 设置适配器
        setupAdapter();

        addButton.setOnClickListener(v -> {
            try {
                // 1. 获取输入值
                String name = nameEditText.getText().toString();
                String nameId = nameIdEditText.getText().toString();
                int type = Integer.parseInt(typeEditText.getText().toString());
                int status = Integer.parseInt(statusEditText.getText().toString());
                long id = System.currentTimeMillis();

                // 2. 创建新条目
                JSONObject newChat = new JSONObject();
                newChat.put("id", id);
                newChat.put("name", name);
                newChat.put("name_id", nameId);
                newChat.put("type", type);
                newChat.put("status", status);

                // 3. 读取现有数据
                JSONArray chatsArray = JsonFileManager.loadData(getContext());

                // 4. 添加新条目
                chatsArray.put(newChat);

                // 5. 保存数据
                JsonFileManager.saveData(getContext(), chatsArray);

                // 6. 刷新UI
                refreshData();

                // 7. 清空输入框
                nameEditText.setText("");
                nameIdEditText.setText("");
                typeEditText.setText("");
                statusEditText.setText("");

            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "请输入有效的数字", Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                Toast.makeText(getContext(), "数据格式错误", Toast.LENGTH_SHORT).show();
            }
        });



        return fragmentView;
    }

    private void setupAdapter() {
        String[] from = new String[]{

        };

        int[] to = new int[]{
                R.id.item_name,
                R.id.item_name_id,
                R.id.item_type,
                R.id.item_status
        };

        adapter = new SimpleCursorAdapter(
                getParentActivity(),
                R.layout.chats_info_item,
                null,
                from,
                to,
                0
        );

        listView.setAdapter(adapter);
        refreshData();
    }

    private void refreshData() {
//        Cursor cursor = database.getAllChats();
//        adapter.changeCursor(cursor);
    }

    public void onDestroy() {
//        super.onDestroy();

    }
}
