package cursoandroid.whatsappandroid.com.br.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import cursoandroid.whatsappandroid.com.br.R;
import cursoandroid.whatsappandroid.com.br.config.ConfigFirebase;
import cursoandroid.whatsappandroid.com.br.helper.Base64Custom;
import cursoandroid.whatsappandroid.com.br.helper.Preferencias;
import cursoandroid.whatsappandroid.com.br.model.Usuario;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private EditText txtNome2;
    private EditText txtEmail2;
    private EditText txtSenha2;

    private Button btnCadastrar2;

    private Usuario usuario;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        txtNome2 = findViewById(R.id.txtNome2);
        txtEmail2 = findViewById(R.id.txtEmail2);
        txtSenha2 = findViewById(R.id.txtSenha2);
        btnCadastrar2 = findViewById(R.id.btnCadastrar2);

        btnCadastrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = new Usuario();
                usuario.setNome(txtNome2.getText().toString());
                usuario.setEmail(txtEmail2.getText().toString());
                usuario.setSenha(txtSenha2.getText().toString());
                cadastrarUsuario();
            }
        });
    }

    public void cadastrarUsuario(){
        auth = ConfigFirebase.getFirebaseAutenticacao();
        auth.createUserWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(CadastroUsuarioActivity.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(CadastroUsuarioActivity.this,
                                    "Sucesso ao cadastrar usuário",
                                    Toast.LENGTH_LONG).show();
                            FirebaseUser usuarioFirebase = task.getResult().getUser();

                            String identificadorUsuario = Base64Custom.codificarBase64(usuario.getEmail());

                            usuario.setId(identificadorUsuario);
                            usuario.salvar();

                            Preferencias preferencias = new Preferencias(CadastroUsuarioActivity.this);
                            preferencias.salvarDados(identificadorUsuario, usuario.getNome());

                            abrirLoginUsuario();
                        } else {
                            String erroExcecao = "";

                            try {
                                throw task.getException();
                            }catch (FirebaseAuthWeakPasswordException e){
                                erroExcecao = "Digite uma senha mais forte, contendo mais caracteres e com letras e números!";
                            } catch (FirebaseAuthInvalidCredentialsException e){
                                erroExcecao = "O e-mail digitado é inválido, digite um novo e-mail!";
                            } catch (FirebaseAuthUserCollisionException e){
                                erroExcecao = "Esse e-mail já está em uso no App!";
                            } catch (Exception e) {
                                erroExcecao = "Erro ao cadastrar usuário";
                                e.printStackTrace();
                            }

                            Toast.makeText(CadastroUsuarioActivity.this,
                                    "Erro: " + erroExcecao,
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void abrirLoginUsuario(){
        Intent intent = new Intent(CadastroUsuarioActivity.this, Login2Activity.class);
        startActivity(intent);
        finish();
    }
}