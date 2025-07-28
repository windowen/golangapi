package org.telegram.ui;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import org.telegram.SQLite.SQLitePreparedStatement;
import org.telegram.messenger.AndroidUtilities;
import org.telegram.messenger.FileLog;
import org.telegram.messenger.MessagesStorage;
import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.BaseFragment;
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

        // 添加按钮点击事件
        addButton.setOnClickListener(v -> {
            try {
                // 获取输入值
                String name = nameEditText.getText().toString();
                String nameId = nameIdEditText.getText().toString();
                int type = Integer.parseInt(typeEditText.getText().toString());
                int status = Integer.parseInt(statusEditText.getText().toString());

                // 使用当前时间戳作为ID（或根据业务需求生成）
                long id = System.currentTimeMillis();

                // 通过 MessagesStorage 的线程执行数据库操作
                MessagesStorage storage = MessagesStorage.getInstance(currentAccount);
                storage.getStorageQueue().postRunnable(() -> {
                    SQLitePreparedStatement state = null;
                    try {
                        org.telegram.SQLite.SQLiteDatabase db = storage.getDatabase();

                        if (db == null) {
                            return;
                        }
                        // 准备插入语句
                        state = db.executeFast("INSERT OR REPLACE INTO chats_info VALUES (?, ?, ?, ?, ?)");
                        state.requery();
                        // 绑定参数
                        state.bindLong(1, id);
                        state.bindString(2, name);
                        state.bindString(3, nameId);
                        state.bindInteger(4, type);
                        state.bindInteger(5, status);

                        // 执行插入
                        state.step();

                        FileLog.d("Successfully inserted chat info: id=" + id + ", name=" + name);

                        // 回到UI线程刷新列表
                        AndroidUtilities.runOnUIThread(() -> refreshData());

                    } catch (Exception e) {
                        FileLog.e("插入数据失败: " + e);
                    } finally {
                        if (state != null) {
                            state.dispose();
                        }
                    }
                });


            } catch (NumberFormatException e) {
                // 处理数字解析错误
                Toast.makeText(getContext(), "请输入有效的数字", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                // 其他异常处理
                FileLog.e("ChatsInfoFragment插入数据失败"+e.getMessage());
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
