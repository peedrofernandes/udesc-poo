/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package apresentacao;

import dados.Post;
import java.sql.SQLException;

import exceptions.ExistingAliasException;
import exceptions.ExistingEmailException;
import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;
import exceptions.InvalidPasswordException;
import exceptions.UnmatchedPasswordsException;
import exceptions.UserNotFoundException;
import exceptions.WrongPasswordException;
import exceptions.SelectException;

import negocio.Sistema;
import dados.Usuario;
import exceptions.InsertException;
import exceptions.UpdateException;
import java.io.File;
import javax.swing.JFileChooser;
import java.sql.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author pedro
 */
public class MainFrame extends javax.swing.JFrame {
    private static Sistema sistema;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
    for (Post p : sistema.getPosts())
        addPostToContainer(p, HomeScreenContainer);
    }
    
    private void displayUserData() {
        Usuario usuarioLogado = sistema.getUsuarioLogado();
        
        if (usuarioLogado == null) return;
        
        ProfileScreenAliasLabel.setText(usuarioLogado.getApelido());
        ProfileScreenUsernameLabel.setText(usuarioLogado.getNomeCompleto());
        ProfileScreenEmailLabel.setText(usuarioLogado.getEmail());
        ProfileScreenBioLabel.setText(usuarioLogado.getBiografia());
    }
    
    private void addPostToContainer(Post p, javax.swing.JPanel container) {

        javax.swing.JPanel Post = new javax.swing.JPanel();
        javax.swing.JPanel PostPicturePanel = new javax.swing.JPanel();
        javax.swing.JLabel HomeScreenPostPictureLabel = new javax.swing.JLabel();
        javax.swing.JLabel PostDateLabel = new javax.swing.JLabel();
        javax.swing.JLabel PostCaptionLabel = new javax.swing.JLabel();
        javax.swing.JLabel CommentsTitle = new javax.swing.JLabel();
        javax.swing.JPanel Comment1 = new javax.swing.JPanel();
        javax.swing.JLabel CommentAuthorLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel CommentTextLabel1 = new javax.swing.JLabel();
        javax.swing.JPanel Comment2 = new javax.swing.JPanel();
        javax.swing.JLabel CommentAuthorLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel CommentTextLabel2 = new javax.swing.JLabel();
        javax.swing.JPanel Comment3 = new javax.swing.JPanel();
        javax.swing.JLabel CommentAuthorLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel CommentTextLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PostPicturePanel.setBackground(new java.awt.Color(255, 255, 102));

        javax.swing.GroupLayout PostPicturePanelLayout = new javax.swing.GroupLayout(PostPicturePanel);
        PostPicturePanel.setLayout(PostPicturePanelLayout);
        PostPicturePanelLayout.setHorizontalGroup(
            PostPicturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PostPicturePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeScreenPostPictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );
        PostPicturePanelLayout.setVerticalGroup(
            PostPicturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PostPicturePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeScreenPostPictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );

        PostDateLabel.setText("(dd/mm/yyyy)");

        PostCaptionLabel.setText("(Legenda)");

        CommentsTitle.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        CommentsTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CommentsTitle.setText("Comentários recentes");

        Comment1.setBackground(new java.awt.Color(255, 255, 255));

        CommentAuthorLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        CommentAuthorLabel1.setText("(Autor)");

        CommentTextLabel1.setText("Texto");

        javax.swing.GroupLayout Comment1Layout = new javax.swing.GroupLayout(Comment1);
        Comment1.setLayout(Comment1Layout);
        Comment1Layout.setHorizontalGroup(
            Comment1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Comment1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Comment1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CommentAuthorLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CommentTextLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Comment1Layout.setVerticalGroup(
            Comment1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Comment1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CommentAuthorLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CommentTextLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        Comment2.setBackground(new java.awt.Color(255, 255, 255));

        CommentAuthorLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        CommentAuthorLabel2.setText("(Autor)");

        CommentTextLabel2.setText("Texto");

        javax.swing.GroupLayout Comment2Layout = new javax.swing.GroupLayout(Comment2);
        Comment2.setLayout(Comment2Layout);
        Comment2Layout.setHorizontalGroup(
            Comment2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Comment2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Comment2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CommentAuthorLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CommentTextLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Comment2Layout.setVerticalGroup(
            Comment2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Comment2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CommentAuthorLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CommentTextLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        Comment3.setBackground(new java.awt.Color(255, 255, 255));

        CommentAuthorLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        CommentAuthorLabel3.setText("(Autor)");

        CommentTextLabel3.setText("Texto");

        javax.swing.GroupLayout Comment3Layout = new javax.swing.GroupLayout(Comment3);
        Comment3.setLayout(Comment3Layout);
        Comment3Layout.setHorizontalGroup(
            Comment3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Comment3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Comment3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CommentAuthorLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CommentTextLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Comment3Layout.setVerticalGroup(
            Comment3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Comment3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CommentAuthorLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CommentTextLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PostLayout = new javax.swing.GroupLayout(Post);
        Post.setLayout(PostLayout);
        PostLayout.setHorizontalGroup(
            PostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PostLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PostPicturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PostDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PostCaptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CommentsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                    .addComponent(Comment1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Comment2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Comment3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PostLayout.setVerticalGroup(
            PostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PostLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PostPicturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PostLayout.createSequentialGroup()
                        .addComponent(PostDateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PostCaptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CommentsTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Comment1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Comment2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Comment3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(572, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Post, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 907, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Post, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        
//        javax.swing.JPanel Post = new javax.swing.JPanel();
//        javax.swing.JPanel PostPicturePanel = new javax.swing.JPanel();
//        javax.swing.JLabel HomeScreenPostPictureLabel = new javax.swing.JLabel();
//        javax.swing.JLabel PostDateLabel = new javax.swing.JLabel();
//        javax.swing.JLabel PostCaptionLabel = new javax.swing.JLabel();
//        javax.swing.JLabel CommentsTitle = new javax.swing.JLabel();
//        javax.swing.JPanel Comment1 = new javax.swing.JPanel();
//        javax.swing.JLabel CommentAuthorLabel1 = new javax.swing.JLabel();
//        javax.swing.JLabel CommentTextLabel1 = new javax.swing.JLabel();
//        javax.swing.JPanel Comment2 = new javax.swing.JPanel();
//        javax.swing.JLabel CommentAuthorLabel2 = new javax.swing.JLabel();
//        javax.swing.JLabel CommentTextLabel2 = new javax.swing.JLabel();
//        javax.swing.JPanel Comment3 = new javax.swing.JPanel();
//        javax.swing.JLabel CommentAuthorLabel3 = new javax.swing.JLabel();
//        javax.swing.JLabel CommentTextLabel3 = new javax.swing.JLabel();

        File postImage = new File("post-" + p.getId() + ".png");
        String imagePath = postImage.getAbsolutePath();
        HomeScreenPostPictureLabel.setIcon(new ImageIcon(imagePath));
        PostDateLabel.setText(String.valueOf(p.getDataPublicacao()));
        PostCaptionLabel.setText(p.getLegenda());
        
        pack();

        container.add(Post);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        Container = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        HeaderProfile = new javax.swing.JPanel();
        ProfileIcon = new javax.swing.JLabel();
        HeaderHome = new javax.swing.JPanel();
        HomeIcon = new javax.swing.JLabel();
        HeaderMessages = new javax.swing.JPanel();
        MessagesIcon = new javax.swing.JLabel();
        Screens = new javax.swing.JTabbedPane();
        RegisterScreen = new javax.swing.JPanel();
        RegisterScreenContainer = new javax.swing.JPanel();
        RegisterScreenTitle = new javax.swing.JLabel();
        RegisterScreenEmailInputLabel = new javax.swing.JLabel();
        RegisterScreenEmailInput = new javax.swing.JTextField();
        RegisterScreenNameInputLabel = new javax.swing.JLabel();
        RegisterScreenNameInput = new javax.swing.JTextField();
        RegisterScreenAliasInputLabel = new javax.swing.JLabel();
        RegisterScreenAliasInput = new javax.swing.JTextField();
        RegisterScreenPasswordInputLabel = new javax.swing.JLabel();
        RegisterScreenConfirmpasswordInputLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        RegisterButton = new javax.swing.JButton();
        GoToLoginScreenButton = new javax.swing.JButton();
        RegisterScreenExceptionsLabel = new javax.swing.JLabel();
        RegisterScreenPasswordInput = new javax.swing.JPasswordField();
        RegisterScreenPasswordConfirmInput = new javax.swing.JPasswordField();
        LoginScreen = new javax.swing.JPanel();
        LoginScreenContainer = new javax.swing.JPanel();
        LoginScreenTitle = new javax.swing.JLabel();
        LoginScreenEmailInputLabel = new javax.swing.JLabel();
        LoginScreenEmailInput = new javax.swing.JTextField();
        LoginScreenPasswordInputLabel = new javax.swing.JLabel();
        LoginScreenPasswordInput = new javax.swing.JPasswordField();
        LoginScreenLoginButton = new javax.swing.JButton();
        LoginScreenRegisterLabel = new javax.swing.JLabel();
        LoginScreenRegisterButton = new javax.swing.JButton();
        LoginScreenExceptionsLabel = new javax.swing.JLabel();
        ProfileScreen = new javax.swing.JPanel();
        ProfileScreenContainer = new javax.swing.JPanel();
        ProfileScreenUserInfoContainer = new javax.swing.JPanel();
        ProfileScreenAliasLabel = new javax.swing.JLabel();
        ProfileScreenUsernameLabel = new javax.swing.JLabel();
        ProfileScreenEmailLabel = new javax.swing.JLabel();
        ProfileScreenBioLabel = new javax.swing.JLabel();
        ProfileScreenModifyUserContainer = new javax.swing.JPanel();
        ProfileScreenAlterGeneralDataTitle = new javax.swing.JLabel();
        ProfileScreenAlterEmailLabel = new javax.swing.JLabel();
        ProfileScreenAlterEmailInput = new javax.swing.JTextField();
        ProfileScreenAlterNameLabel = new javax.swing.JLabel();
        ProfileScreenAlterNameInput = new javax.swing.JTextField();
        ProfileScreenAlterAliasLabel = new javax.swing.JLabel();
        ProfileScreenAlterAliasInput = new javax.swing.JTextField();
        ProfileScreenAlterBioLabel = new javax.swing.JLabel();
        ProfileScreenAlterBioInput = new javax.swing.JTextField();
        ProfileScreenAlterGeneralDataButton = new javax.swing.JButton();
        ProfileScreenAlterPasswordTitle = new javax.swing.JLabel();
        ProfileScreenAlterPasswordLabel = new javax.swing.JLabel();
        ProfileScreenAlterPasswordInput = new javax.swing.JPasswordField();
        ProfileScreenAlterConfirmpasswordLabel = new javax.swing.JLabel();
        ProfileScreenAlterConfirmpasswordInput = new javax.swing.JPasswordField();
        ProfileScreenAlterPasswordButton = new javax.swing.JButton();
        ProfileScreenExceptionsLabel = new javax.swing.JLabel();
        Post = new javax.swing.JPanel();
        PostPicturePanel = new javax.swing.JPanel();
        PostPictureLabel = new javax.swing.JLabel();
        PostDateLabel = new javax.swing.JLabel();
        PostCaptionLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Comment = new javax.swing.JPanel();
        CommentAuthorLabel = new javax.swing.JLabel();
        CommentTextLabel = new javax.swing.JLabel();
        Comment1 = new javax.swing.JPanel();
        Comment1AuthorLabel = new javax.swing.JLabel();
        Comment1TextLabel = new javax.swing.JLabel();
        Comment2 = new javax.swing.JPanel();
        Comment2AuthorLabel = new javax.swing.JLabel();
        Comment2TextLabel = new javax.swing.JLabel();
        NewPostButton = new javax.swing.JButton();
        HomeScreen = new javax.swing.JPanel();
        HomeScreenContainer = new javax.swing.JPanel();
        MessagesScreen = new javax.swing.JPanel();
        LoginScreenContainer1 = new javax.swing.JPanel();
        ConversationContainer = new javax.swing.JPanel();
        ConversationPicPanel = new javax.swing.JPanel();
        ConversationPicLabel = new javax.swing.JLabel();
        ConversationLastMessageContainer = new javax.swing.JPanel();
        ConversationLastMessageDateLabel = new javax.swing.JLabel();
        ConversationLastMessageTextLabel = new javax.swing.JLabel();
        ConversationContainer1 = new javax.swing.JPanel();
        ConversationPicPanel1 = new javax.swing.JPanel();
        ConversationPicLabel1 = new javax.swing.JLabel();
        ConversationLastMessageContainer1 = new javax.swing.JPanel();
        ConversationLastMessageDateLabel1 = new javax.swing.JLabel();
        ConversationLastMessageTextLabel1 = new javax.swing.JLabel();
        NewPostScreen = new javax.swing.JPanel();
        NewPostScreenContainer = new javax.swing.JPanel();
        NewPostScreenPicLabel = new javax.swing.JLabel();
        NewPostScreenPicChooseButton = new javax.swing.JButton();
        NewPostScreenCaptionLabel = new javax.swing.JLabel();
        NewPostScreenCaptionInput = new javax.swing.JTextField();
        CreatePostButton = new javax.swing.JButton();
        NewPostScreenAbsoluteFilePathValue = new javax.swing.JTextField();
        NewPostScreenExceptionsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setMaximumSize(new java.awt.Dimension(772, 32767));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(772, 447));

        Container.setBackground(new java.awt.Color(255, 255, 255));
        Container.setMinimumSize(new java.awt.Dimension(770, 447));
        Container.setName(""); // NOI18N
        Container.setPreferredSize(new java.awt.Dimension(770, 955));
        Container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        Header.setLayout(new java.awt.GridLayout(1, 3));

        HeaderProfile.setBackground(new java.awt.Color(255, 255, 255));
        HeaderProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeaderProfileMouseClicked(evt);
            }
        });

        ProfileIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProfileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/profile-icon.png"))); // NOI18N
        ProfileIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ProfileIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProfileIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout HeaderProfileLayout = new javax.swing.GroupLayout(HeaderProfile);
        HeaderProfile.setLayout(HeaderProfileLayout);
        HeaderProfileLayout.setHorizontalGroup(
            HeaderProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ProfileIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        HeaderProfileLayout.setVerticalGroup(
            HeaderProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ProfileIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        Header.add(HeaderProfile);

        HeaderHome.setBackground(new java.awt.Color(255, 255, 255));
        HeaderHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeaderHomeMouseClicked(evt);
            }
        });

        HomeIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HomeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/home-icon.png"))); // NOI18N
        HomeIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HomeIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout HeaderHomeLayout = new javax.swing.GroupLayout(HeaderHome);
        HeaderHome.setLayout(HeaderHomeLayout);
        HeaderHomeLayout.setHorizontalGroup(
            HeaderHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomeIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        HeaderHomeLayout.setVerticalGroup(
            HeaderHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        Header.add(HeaderHome);

        HeaderMessages.setBackground(new java.awt.Color(255, 255, 255));

        MessagesIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MessagesIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/chat-icon.png"))); // NOI18N
        MessagesIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MessagesIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MessagesIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout HeaderMessagesLayout = new javax.swing.GroupLayout(HeaderMessages);
        HeaderMessages.setLayout(HeaderMessagesLayout);
        HeaderMessagesLayout.setHorizontalGroup(
            HeaderMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MessagesIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        HeaderMessagesLayout.setVerticalGroup(
            HeaderMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MessagesIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        Header.add(HeaderMessages);

        Container.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 768, -1));

        RegisterScreen.setBackground(new java.awt.Color(255, 255, 255));
        RegisterScreen.setMaximumSize(new java.awt.Dimension(2147483647, 387));
        RegisterScreen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RegisterScreenContainer.setBackground(new java.awt.Color(204, 204, 204));

        RegisterScreenTitle.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        RegisterScreenTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RegisterScreenTitle.setText("Registre-se!");

        RegisterScreenEmailInputLabel.setText("E-mail:");

        RegisterScreenEmailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterScreenEmailInputActionPerformed(evt);
            }
        });

        RegisterScreenNameInputLabel.setText("Nome Completo:");

        RegisterScreenAliasInputLabel.setText("Apelido de usuário:");

        RegisterScreenAliasInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterScreenAliasInputActionPerformed(evt);
            }
        });

        RegisterScreenPasswordInputLabel.setText("Senha:");

        RegisterScreenConfirmpasswordInputLabel.setText("Confirmar Senha:");

        jLabel7.setText("Já tem uma conta? Faça login!");

        RegisterButton.setText("Registrar");
        RegisterButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        RegisterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegisterButtonMouseClicked(evt);
            }
        });
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        GoToLoginScreenButton.setText("Fazer login");
        GoToLoginScreenButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        GoToLoginScreenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GoToLoginScreenButtonMouseClicked(evt);
            }
        });
        GoToLoginScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoToLoginScreenButtonActionPerformed(evt);
            }
        });

        RegisterScreenExceptionsLabel.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout RegisterScreenContainerLayout = new javax.swing.GroupLayout(RegisterScreenContainer);
        RegisterScreenContainer.setLayout(RegisterScreenContainerLayout);
        RegisterScreenContainerLayout.setHorizontalGroup(
            RegisterScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RegisterScreenTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(RegisterScreenContainerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(RegisterScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RegisterScreenEmailInput)
                    .addComponent(RegisterScreenNameInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterScreenEmailInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterScreenNameInput)
                    .addComponent(RegisterScreenAliasInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(RegisterScreenAliasInput)
                    .addComponent(RegisterScreenPasswordInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterScreenConfirmpasswordInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(RegisterScreenContainerLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(RegisterButton))
                    .addComponent(RegisterScreenPasswordInput)
                    .addComponent(RegisterScreenPasswordConfirmInput))
                .addGroup(RegisterScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(RegisterScreenContainerLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(GoToLoginScreenButton))
                    .addGroup(RegisterScreenContainerLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel7))
                    .addGroup(RegisterScreenContainerLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(RegisterScreenExceptionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        RegisterScreenContainerLayout.setVerticalGroup(
            RegisterScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterScreenContainerLayout.createSequentialGroup()
                .addComponent(RegisterScreenTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(RegisterScreenContainerLayout.createSequentialGroup()
                        .addComponent(RegisterScreenEmailInputLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RegisterScreenEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RegisterScreenNameInputLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RegisterScreenNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RegisterScreenAliasInputLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RegisterScreenAliasInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RegisterScreenPasswordInputLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RegisterScreenPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(RegisterScreenExceptionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(RegisterScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegisterScreenContainerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RegisterScreenConfirmpasswordInputLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RegisterScreenPasswordConfirmInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(RegisterButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterScreenContainerLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GoToLoginScreenButton)
                        .addGap(26, 26, 26))))
        );

        RegisterScreen.add(RegisterScreenContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 650, -1));

        Screens.addTab("tab1", RegisterScreen);

        LoginScreen.setBackground(new java.awt.Color(255, 255, 255));

        LoginScreenContainer.setBackground(new java.awt.Color(204, 204, 204));

        LoginScreenTitle.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        LoginScreenTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginScreenTitle.setText("Fazer Login");

        LoginScreenEmailInputLabel.setText("E-mail:");

        LoginScreenEmailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginScreenEmailInputActionPerformed(evt);
            }
        });

        LoginScreenPasswordInputLabel.setText("Senha:");

        LoginScreenLoginButton.setText("Login");
        LoginScreenLoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginScreenLoginButtonMouseClicked(evt);
            }
        });
        LoginScreenLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginScreenLoginButtonActionPerformed(evt);
            }
        });

        LoginScreenRegisterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginScreenRegisterLabel.setText("Não tem uma conta? Registre-se");

        LoginScreenRegisterButton.setText("Registre-se");
        LoginScreenRegisterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginScreenRegisterButtonMouseClicked(evt);
            }
        });
        LoginScreenRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginScreenRegisterButtonActionPerformed(evt);
            }
        });

        LoginScreenExceptionsLabel.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout LoginScreenContainerLayout = new javax.swing.GroupLayout(LoginScreenContainer);
        LoginScreenContainer.setLayout(LoginScreenContainerLayout);
        LoginScreenContainerLayout.setHorizontalGroup(
            LoginScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginScreenTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LoginScreenContainerLayout.createSequentialGroup()
                .addGroup(LoginScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginScreenContainerLayout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(LoginScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LoginScreenEmailInput, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(LoginScreenPasswordInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LoginScreenEmailInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginScreenContainerLayout.createSequentialGroup()
                                .addGroup(LoginScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(LoginScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(LoginScreenRegisterLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(LoginScreenContainerLayout.createSequentialGroup()
                                            .addGap(82, 82, 82)
                                            .addComponent(LoginScreenRegisterButton)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(LoginScreenExceptionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(3, 3, 3))
                            .addComponent(LoginScreenPasswordInput)))
                    .addGroup(LoginScreenContainerLayout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(LoginScreenLoginButton)))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        LoginScreenContainerLayout.setVerticalGroup(
            LoginScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginScreenContainerLayout.createSequentialGroup()
                .addComponent(LoginScreenTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginScreenEmailInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginScreenEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginScreenPasswordInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginScreenPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginScreenLoginButton)
                .addGap(11, 11, 11)
                .addComponent(LoginScreenExceptionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginScreenRegisterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginScreenRegisterButton)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout LoginScreenLayout = new javax.swing.GroupLayout(LoginScreen);
        LoginScreen.setLayout(LoginScreenLayout);
        LoginScreenLayout.setHorizontalGroup(
            LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginScreenLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(LoginScreenContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        LoginScreenLayout.setVerticalGroup(
            LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginScreenLayout.createSequentialGroup()
                .addComponent(LoginScreenContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 519, Short.MAX_VALUE))
        );

        Screens.addTab("tab2", LoginScreen);

        ProfileScreen.setBackground(new java.awt.Color(255, 255, 255));

        ProfileScreenContainer.setBackground(new java.awt.Color(204, 204, 204));

        ProfileScreenAliasLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProfileScreenAliasLabel.setText("(Apelido do usuário)");

        ProfileScreenUsernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProfileScreenUsernameLabel.setText("(Nome do usuário)");

        ProfileScreenEmailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProfileScreenEmailLabel.setText("(Email do usuário)");

        ProfileScreenBioLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProfileScreenBioLabel.setText("(Biografia do usuário)");

        javax.swing.GroupLayout ProfileScreenUserInfoContainerLayout = new javax.swing.GroupLayout(ProfileScreenUserInfoContainer);
        ProfileScreenUserInfoContainer.setLayout(ProfileScreenUserInfoContainerLayout);
        ProfileScreenUserInfoContainerLayout.setHorizontalGroup(
            ProfileScreenUserInfoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileScreenUserInfoContainerLayout.createSequentialGroup()
                .addGroup(ProfileScreenUserInfoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ProfileScreenAliasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProfileScreenUsernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProfileScreenEmailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProfileScreenBioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ProfileScreenUserInfoContainerLayout.setVerticalGroup(
            ProfileScreenUserInfoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileScreenUserInfoContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ProfileScreenAliasLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProfileScreenUsernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProfileScreenEmailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProfileScreenBioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        ProfileScreenAlterGeneralDataTitle.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        ProfileScreenAlterGeneralDataTitle.setText("Alterar dados gerais");

        ProfileScreenAlterEmailLabel.setText("Email:");

        ProfileScreenAlterEmailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileScreenAlterEmailInputActionPerformed(evt);
            }
        });

        ProfileScreenAlterNameLabel.setText("Nome:");

        ProfileScreenAlterNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileScreenAlterNameInputActionPerformed(evt);
            }
        });

        ProfileScreenAlterAliasLabel.setText("Apelido");

        ProfileScreenAlterAliasInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileScreenAlterAliasInputActionPerformed(evt);
            }
        });

        ProfileScreenAlterBioLabel.setText("Biografia:");

        ProfileScreenAlterBioInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileScreenAlterBioInputActionPerformed(evt);
            }
        });

        ProfileScreenAlterGeneralDataButton.setText("Alterar");
        ProfileScreenAlterGeneralDataButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProfileScreenAlterGeneralDataButtonMouseClicked(evt);
            }
        });

        ProfileScreenAlterPasswordTitle.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        ProfileScreenAlterPasswordTitle.setText("Alterar Senha");

        ProfileScreenAlterPasswordLabel.setText("Nova senha:");

        ProfileScreenAlterPasswordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileScreenAlterPasswordInputActionPerformed(evt);
            }
        });

        ProfileScreenAlterConfirmpasswordLabel.setText("Confirmar nova senha:");

        ProfileScreenAlterConfirmpasswordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileScreenAlterConfirmpasswordInputActionPerformed(evt);
            }
        });

        ProfileScreenAlterPasswordButton.setText("Alterar");
        ProfileScreenAlterPasswordButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProfileScreenAlterPasswordButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ProfileScreenModifyUserContainerLayout = new javax.swing.GroupLayout(ProfileScreenModifyUserContainer);
        ProfileScreenModifyUserContainer.setLayout(ProfileScreenModifyUserContainerLayout);
        ProfileScreenModifyUserContainerLayout.setHorizontalGroup(
            ProfileScreenModifyUserContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileScreenModifyUserContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProfileScreenModifyUserContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProfileScreenModifyUserContainerLayout.createSequentialGroup()
                        .addComponent(ProfileScreenAlterNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProfileScreenAlterConfirmpasswordInput)
                        .addContainerGap())
                    .addGroup(ProfileScreenModifyUserContainerLayout.createSequentialGroup()
                        .addGroup(ProfileScreenModifyUserContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ProfileScreenAlterAliasInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addComponent(ProfileScreenAlterBioInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProfileScreenAlterNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ProfileScreenAlterGeneralDataTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addComponent(ProfileScreenAlterAliasLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ProfileScreenAlterBioLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ProfileScreenAlterEmailInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProfileScreenAlterEmailLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(ProfileScreenModifyUserContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProfileScreenModifyUserContainerLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ProfileScreenModifyUserContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ProfileScreenModifyUserContainerLayout.createSequentialGroup()
                                        .addComponent(ProfileScreenAlterPasswordTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 58, Short.MAX_VALUE))
                                    .addGroup(ProfileScreenModifyUserContainerLayout.createSequentialGroup()
                                        .addGroup(ProfileScreenModifyUserContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ProfileScreenAlterConfirmpasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ProfileScreenAlterPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ProfileScreenAlterPasswordInput))
                                        .addContainerGap())
                                    .addComponent(ProfileScreenExceptionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(ProfileScreenModifyUserContainerLayout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(ProfileScreenAlterPasswordButton)
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(ProfileScreenModifyUserContainerLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(ProfileScreenAlterGeneralDataButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ProfileScreenModifyUserContainerLayout.setVerticalGroup(
            ProfileScreenModifyUserContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileScreenModifyUserContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProfileScreenModifyUserContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProfileScreenAlterGeneralDataTitle)
                    .addComponent(ProfileScreenAlterPasswordTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProfileScreenModifyUserContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProfileScreenAlterPasswordLabel)
                    .addComponent(ProfileScreenAlterEmailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProfileScreenModifyUserContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProfileScreenAlterPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProfileScreenAlterEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProfileScreenModifyUserContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProfileScreenAlterConfirmpasswordLabel)
                    .addComponent(ProfileScreenAlterNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProfileScreenModifyUserContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProfileScreenAlterConfirmpasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProfileScreenAlterNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProfileScreenModifyUserContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProfileScreenAlterPasswordButton)
                    .addComponent(ProfileScreenAlterAliasLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ProfileScreenModifyUserContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProfileScreenModifyUserContainerLayout.createSequentialGroup()
                        .addComponent(ProfileScreenAlterAliasInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProfileScreenAlterBioLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProfileScreenAlterBioInput, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProfileScreenModifyUserContainerLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(ProfileScreenExceptionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProfileScreenAlterGeneralDataButton)
                .addGap(88, 88, 88))
        );

        PostPicturePanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PostPicturePanelLayout = new javax.swing.GroupLayout(PostPicturePanel);
        PostPicturePanel.setLayout(PostPicturePanelLayout);
        PostPicturePanelLayout.setHorizontalGroup(
            PostPicturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PostPicturePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PostPictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );
        PostPicturePanelLayout.setVerticalGroup(
            PostPicturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PostPicturePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PostPictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );

        PostDateLabel.setText("(dd/mm/yyyy)");

        PostCaptionLabel.setText("(Legenda)");

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Comentários recentes");

        Comment.setBackground(new java.awt.Color(255, 255, 255));

        CommentAuthorLabel.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        CommentAuthorLabel.setText("(Autor)");

        CommentTextLabel.setText("Texto");

        javax.swing.GroupLayout CommentLayout = new javax.swing.GroupLayout(Comment);
        Comment.setLayout(CommentLayout);
        CommentLayout.setHorizontalGroup(
            CommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CommentAuthorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CommentTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        CommentLayout.setVerticalGroup(
            CommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CommentAuthorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CommentTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        Comment1.setBackground(new java.awt.Color(255, 255, 255));

        Comment1AuthorLabel.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        Comment1AuthorLabel.setText("(Autor)");

        Comment1TextLabel.setText("Texto");

        javax.swing.GroupLayout Comment1Layout = new javax.swing.GroupLayout(Comment1);
        Comment1.setLayout(Comment1Layout);
        Comment1Layout.setHorizontalGroup(
            Comment1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Comment1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Comment1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Comment1AuthorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Comment1TextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Comment1Layout.setVerticalGroup(
            Comment1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Comment1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Comment1AuthorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Comment1TextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        Comment2.setBackground(new java.awt.Color(255, 255, 255));

        Comment2AuthorLabel.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        Comment2AuthorLabel.setText("(Autor)");

        Comment2TextLabel.setText("Texto");

        javax.swing.GroupLayout Comment2Layout = new javax.swing.GroupLayout(Comment2);
        Comment2.setLayout(Comment2Layout);
        Comment2Layout.setHorizontalGroup(
            Comment2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Comment2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Comment2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Comment2AuthorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Comment2TextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Comment2Layout.setVerticalGroup(
            Comment2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Comment2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Comment2AuthorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Comment2TextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PostLayout = new javax.swing.GroupLayout(Post);
        Post.setLayout(PostLayout);
        PostLayout.setHorizontalGroup(
            PostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PostLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PostPicturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PostLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(PostDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(PostCaptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                    .addComponent(Comment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Comment1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Comment2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PostLayout.setVerticalGroup(
            PostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PostLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PostPicturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PostLayout.createSequentialGroup()
                        .addComponent(PostDateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PostCaptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Comment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Comment1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Comment2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        NewPostButton.setText("Criar novo Post");
        NewPostButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewPostButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ProfileScreenContainerLayout = new javax.swing.GroupLayout(ProfileScreenContainer);
        ProfileScreenContainer.setLayout(ProfileScreenContainerLayout);
        ProfileScreenContainerLayout.setHorizontalGroup(
            ProfileScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileScreenContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProfileScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProfileScreenModifyUserContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProfileScreenUserInfoContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Post, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(ProfileScreenContainerLayout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(NewPostButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProfileScreenContainerLayout.setVerticalGroup(
            ProfileScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileScreenContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ProfileScreenUserInfoContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProfileScreenModifyUserContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NewPostButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Post, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout ProfileScreenLayout = new javax.swing.GroupLayout(ProfileScreen);
        ProfileScreen.setLayout(ProfileScreenLayout);
        ProfileScreenLayout.setHorizontalGroup(
            ProfileScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileScreenLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(ProfileScreenContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        ProfileScreenLayout.setVerticalGroup(
            ProfileScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ProfileScreenContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Screens.addTab("tab3", ProfileScreen);

        HomeScreen.setBackground(new java.awt.Color(255, 255, 255));

        HomeScreenContainer.setBackground(new java.awt.Color(204, 204, 204));
        HomeScreenContainer.setLayout(new java.awt.GridLayout(0, 1, 0, 3));

        javax.swing.GroupLayout HomeScreenLayout = new javax.swing.GroupLayout(HomeScreen);
        HomeScreen.setLayout(HomeScreenLayout);
        HomeScreenLayout.setHorizontalGroup(
            HomeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeScreenLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(HomeScreenContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        HomeScreenLayout.setVerticalGroup(
            HomeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomeScreenContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Screens.addTab("tab4", HomeScreen);

        MessagesScreen.setBackground(new java.awt.Color(255, 255, 255));

        LoginScreenContainer1.setBackground(new java.awt.Color(204, 204, 204));
        LoginScreenContainer1.setLayout(new java.awt.GridLayout(0, 1, 0, 4));

        ConversationPicPanel.setBackground(new java.awt.Color(255, 255, 255));

        ConversationPicLabel.setText("(Profile Pic)");

        javax.swing.GroupLayout ConversationPicPanelLayout = new javax.swing.GroupLayout(ConversationPicPanel);
        ConversationPicPanel.setLayout(ConversationPicPanelLayout);
        ConversationPicPanelLayout.setHorizontalGroup(
            ConversationPicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConversationPicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        ConversationPicPanelLayout.setVerticalGroup(
            ConversationPicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConversationPicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        ConversationLastMessageContainer.setBackground(new java.awt.Color(255, 255, 255));

        ConversationLastMessageDateLabel.setText("(Last Message Date)");

        ConversationLastMessageTextLabel.setText("(Last Message)");

        javax.swing.GroupLayout ConversationLastMessageContainerLayout = new javax.swing.GroupLayout(ConversationLastMessageContainer);
        ConversationLastMessageContainer.setLayout(ConversationLastMessageContainerLayout);
        ConversationLastMessageContainerLayout.setHorizontalGroup(
            ConversationLastMessageContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConversationLastMessageContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConversationLastMessageContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ConversationLastMessageTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ConversationLastMessageDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
                .addContainerGap())
        );
        ConversationLastMessageContainerLayout.setVerticalGroup(
            ConversationLastMessageContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConversationLastMessageContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ConversationLastMessageDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConversationLastMessageTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ConversationContainerLayout = new javax.swing.GroupLayout(ConversationContainer);
        ConversationContainer.setLayout(ConversationContainerLayout);
        ConversationContainerLayout.setHorizontalGroup(
            ConversationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConversationContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ConversationPicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConversationLastMessageContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ConversationContainerLayout.setVerticalGroup(
            ConversationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConversationContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConversationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ConversationLastMessageContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConversationPicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LoginScreenContainer1.add(ConversationContainer);

        ConversationPicPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ConversationPicLabel1.setText("(Profile Pic)");

        javax.swing.GroupLayout ConversationPicPanel1Layout = new javax.swing.GroupLayout(ConversationPicPanel1);
        ConversationPicPanel1.setLayout(ConversationPicPanel1Layout);
        ConversationPicPanel1Layout.setHorizontalGroup(
            ConversationPicPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConversationPicLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        ConversationPicPanel1Layout.setVerticalGroup(
            ConversationPicPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConversationPicLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        ConversationLastMessageContainer1.setBackground(new java.awt.Color(255, 255, 255));

        ConversationLastMessageDateLabel1.setText("(Last Message Date)");

        ConversationLastMessageTextLabel1.setText("(Last Message)");

        javax.swing.GroupLayout ConversationLastMessageContainer1Layout = new javax.swing.GroupLayout(ConversationLastMessageContainer1);
        ConversationLastMessageContainer1.setLayout(ConversationLastMessageContainer1Layout);
        ConversationLastMessageContainer1Layout.setHorizontalGroup(
            ConversationLastMessageContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConversationLastMessageContainer1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConversationLastMessageContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ConversationLastMessageTextLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ConversationLastMessageDateLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
                .addContainerGap())
        );
        ConversationLastMessageContainer1Layout.setVerticalGroup(
            ConversationLastMessageContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConversationLastMessageContainer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ConversationLastMessageDateLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConversationLastMessageTextLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ConversationContainer1Layout = new javax.swing.GroupLayout(ConversationContainer1);
        ConversationContainer1.setLayout(ConversationContainer1Layout);
        ConversationContainer1Layout.setHorizontalGroup(
            ConversationContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConversationContainer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ConversationPicPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConversationLastMessageContainer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ConversationContainer1Layout.setVerticalGroup(
            ConversationContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConversationContainer1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConversationContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ConversationLastMessageContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConversationPicPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LoginScreenContainer1.add(ConversationContainer1);

        javax.swing.GroupLayout MessagesScreenLayout = new javax.swing.GroupLayout(MessagesScreen);
        MessagesScreen.setLayout(MessagesScreenLayout);
        MessagesScreenLayout.setHorizontalGroup(
            MessagesScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessagesScreenLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(LoginScreenContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MessagesScreenLayout.setVerticalGroup(
            MessagesScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessagesScreenLayout.createSequentialGroup()
                .addComponent(LoginScreenContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 679, Short.MAX_VALUE))
        );

        Screens.addTab("tab5", MessagesScreen);

        NewPostScreenContainer.setBackground(new java.awt.Color(204, 204, 204));

        NewPostScreenPicLabel.setText("Foto:");

        NewPostScreenPicChooseButton.setText("Escolher arquivo");
        NewPostScreenPicChooseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewPostScreenPicChooseButtonMouseClicked(evt);
            }
        });

        NewPostScreenCaptionLabel.setText("Legenda:");

        CreatePostButton.setText("Criar Publicação");
        CreatePostButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreatePostButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout NewPostScreenContainerLayout = new javax.swing.GroupLayout(NewPostScreenContainer);
        NewPostScreenContainer.setLayout(NewPostScreenContainerLayout);
        NewPostScreenContainerLayout.setHorizontalGroup(
            NewPostScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewPostScreenContainerLayout.createSequentialGroup()
                .addGroup(NewPostScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewPostScreenContainerLayout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(CreatePostButton))
                    .addGroup(NewPostScreenContainerLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(NewPostScreenAbsoluteFilePathValue, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(NewPostScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NewPostScreenExceptionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NewPostScreenCaptionInput)
                            .addComponent(NewPostScreenPicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NewPostScreenPicChooseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(NewPostScreenCaptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        NewPostScreenContainerLayout.setVerticalGroup(
            NewPostScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewPostScreenContainerLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(NewPostScreenPicLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NewPostScreenPicChooseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NewPostScreenCaptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NewPostScreenCaptionInput, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CreatePostButton)
                .addGroup(NewPostScreenContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewPostScreenContainerLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(NewPostScreenAbsoluteFilePathValue, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(NewPostScreenContainerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NewPostScreenExceptionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout NewPostScreenLayout = new javax.swing.GroupLayout(NewPostScreen);
        NewPostScreen.setLayout(NewPostScreenLayout);
        NewPostScreenLayout.setHorizontalGroup(
            NewPostScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewPostScreenLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(NewPostScreenContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        NewPostScreenLayout.setVerticalGroup(
            NewPostScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewPostScreenLayout.createSequentialGroup()
                .addComponent(NewPostScreenContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 557, Short.MAX_VALUE))
        );

        Screens.addTab("tab6", NewPostScreen);

        Container.add(Screens, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 26, 770, 940));

        jScrollPane2.setViewportView(Container);

        getContentPane().add(jScrollPane2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HeaderProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderProfileMouseClicked
        // TODO add your handling code here:
        Screens.setSelectedIndex(2);
    }//GEN-LAST:event_HeaderProfileMouseClicked

    private void HeaderHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderHomeMouseClicked
        // TODO add your handling code here:
        Screens.setSelectedIndex(3);
    }//GEN-LAST:event_HeaderHomeMouseClicked

    private void MessagesIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagesIconMouseClicked
        // TODO add your handling code here:
        if (sistema.getUsuarioLogado() == null)
            return;
        
        Screens.setSelectedIndex(4);
    }//GEN-LAST:event_MessagesIconMouseClicked

    private void RegisterScreenEmailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterScreenEmailInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegisterScreenEmailInputActionPerformed

    private void RegisterScreenAliasInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterScreenAliasInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegisterScreenAliasInputActionPerformed

    private void LoginScreenEmailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginScreenEmailInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginScreenEmailInputActionPerformed

    private void ProfileScreenAlterBioInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileScreenAlterBioInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfileScreenAlterBioInputActionPerformed

    private void ProfileScreenAlterNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileScreenAlterNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfileScreenAlterNameInputActionPerformed

    private void ProfileScreenAlterAliasInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileScreenAlterAliasInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfileScreenAlterAliasInputActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void GoToLoginScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoToLoginScreenButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GoToLoginScreenButtonActionPerformed

    private void GoToLoginScreenButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GoToLoginScreenButtonMouseClicked
        // TODO add your handling code here:
        Screens.setSelectedIndex(1);
    }//GEN-LAST:event_GoToLoginScreenButtonMouseClicked

    private void LoginScreenLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginScreenLoginButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginScreenLoginButtonActionPerformed

    private void NewPostButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewPostButtonMouseClicked
        // TODO add your handling code here:
        Screens.setSelectedIndex(5);
    }//GEN-LAST:event_NewPostButtonMouseClicked

    private void RegisterButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterButtonMouseClicked
        // TODO add your handling code here:
        String email = RegisterScreenEmailInput.getText();
        String nomeCompleto = RegisterScreenNameInput.getText();
        String apelido = RegisterScreenAliasInput.getText();
        String senha = String.valueOf(RegisterScreenPasswordInput.getPassword());
        String confirmacaoSenha = String.valueOf(RegisterScreenPasswordConfirmInput.getPassword());
        
        try {
            sistema.cadastrarUsuario(email, nomeCompleto, apelido, senha, confirmacaoSenha);
            System.out.println("Um novo usuário foi cadastrado!");
            System.out.println(sistema.getUsuariosCadastrados());
            Screens.setSelectedIndex(1);
        } catch (ExistingAliasException | ExistingEmailException | InvalidEmailException | InvalidNameException | InvalidPasswordException | UnmatchedPasswordsException | InsertException | SelectException exc) {
            RegisterScreenExceptionsLabel.setText(exc.getMessage());
        }
    }//GEN-LAST:event_RegisterButtonMouseClicked

    private void LoginScreenRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginScreenRegisterButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginScreenRegisterButtonActionPerformed

    private void LoginScreenRegisterButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginScreenRegisterButtonMouseClicked
        // TODO add your handling code here:
        Screens.setSelectedIndex(0);
    }//GEN-LAST:event_LoginScreenRegisterButtonMouseClicked

    private void LoginScreenLoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginScreenLoginButtonMouseClicked
        // TODO add your handling code here:
        String email = LoginScreenEmailInput.getText();
        String senha = String.valueOf(LoginScreenPasswordInput.getPassword());
        
        try {
          sistema.autenticar(email, senha);
          Screens.setSelectedIndex(2);
          displayUserData();
        } catch (InvalidEmailException | InvalidPasswordException | UserNotFoundException | WrongPasswordException exc) {
            LoginScreenExceptionsLabel.setText(exc.getMessage());
        }

        
    }//GEN-LAST:event_LoginScreenLoginButtonMouseClicked

    private void ProfileIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileIconMouseClicked
        // TODO add your handling code here:
        if (sistema.getUsuarioLogado() == null)
            return;
        
        Screens.setSelectedIndex(2);
    }//GEN-LAST:event_ProfileIconMouseClicked

    private void HomeIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeIconMouseClicked
        // TODO add your handling code here:
        if (sistema.getUsuarioLogado() == null)
            return;
        
        Screens.setSelectedIndex(3);
    }//GEN-LAST:event_HomeIconMouseClicked

    private void ProfileScreenAlterConfirmpasswordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileScreenAlterConfirmpasswordInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfileScreenAlterConfirmpasswordInputActionPerformed

    private void ProfileScreenAlterEmailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileScreenAlterEmailInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfileScreenAlterEmailInputActionPerformed

    private void ProfileScreenAlterGeneralDataButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileScreenAlterGeneralDataButtonMouseClicked
        // TODO add your handling code here:
        String email = ProfileScreenAlterEmailInput.getText();
        String nomeCompleto = ProfileScreenAlterNameInput.getText();
        String apelido = ProfileScreenAlterAliasInput.getText();
        String bio = ProfileScreenAlterBioInput.getText();
        
        System.out.println("Email: " + email);
        
        try {
            sistema.editarDadosGeraisUsuario(email, nomeCompleto, apelido, bio);
            ProfileScreenExceptionsLabel.setText("Dados editados com sucesso!");
            displayUserData();
        } catch (ExistingAliasException | InvalidEmailException | InvalidNameException | UpdateException exc) {
            ProfileScreenExceptionsLabel.setText(exc.getMessage());
            displayUserData();
        }
    }//GEN-LAST:event_ProfileScreenAlterGeneralDataButtonMouseClicked

    private void ProfileScreenAlterPasswordButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileScreenAlterPasswordButtonMouseClicked
        // TODO add your handling code here:
        String senha = ProfileScreenAlterPasswordInput.getText();
        String confirmarSenha = ProfileScreenAlterConfirmpasswordInput.getText();
        
        try {
            sistema.editarSenhaUsuario(senha, confirmarSenha);
            ProfileScreenExceptionsLabel.setText("Senha alterada com sucesso!");
        } catch (UnmatchedPasswordsException | UpdateException exc) {
            ProfileScreenExceptionsLabel.setText(exc.getMessage());
        }

    }//GEN-LAST:event_ProfileScreenAlterPasswordButtonMouseClicked

    private void ProfileScreenAlterPasswordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileScreenAlterPasswordInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfileScreenAlterPasswordInputActionPerformed

    private void NewPostScreenPicChooseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewPostScreenPicChooseButtonMouseClicked
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        NewPostScreenAbsoluteFilePathValue.setText(filename);
    }//GEN-LAST:event_NewPostScreenPicChooseButtonMouseClicked

    private void CreatePostButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatePostButtonMouseClicked
        // TODO add your handling code here:
        if (sistema.getUsuarioLogado() == null)
            return;
        
        try {
            String absoluteFilePath = NewPostScreenAbsoluteFilePathValue.getText();
            String caption = NewPostScreenCaptionInput.getText();
            Date date = new Date(new java.util.Date().getTime());

            File arquivo = new File(absoluteFilePath);

            sistema.novoPost(arquivo, caption, date);
            
            Screens.setSelectedIndex(2);
        } catch (InsertException | SelectException exc) {
            NewPostScreenExceptionsLabel.setText(exc.getMessage());
            System.err.println(exc.getMessage());
        }

    }//GEN-LAST:event_CreatePostButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            sistema = new Sistema();
            
        } catch (SQLException | SelectException exc) {
            System.err.println("O programa não pôde ser iniciado por um erro no banco de dados!" + exc.getMessage());
        }

        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Comment;
    private javax.swing.JPanel Comment1;
    private javax.swing.JLabel Comment1AuthorLabel;
    private javax.swing.JLabel Comment1TextLabel;
    private javax.swing.JPanel Comment2;
    private javax.swing.JLabel Comment2AuthorLabel;
    private javax.swing.JLabel Comment2TextLabel;
    private javax.swing.JLabel CommentAuthorLabel;
    private javax.swing.JLabel CommentTextLabel;
    private javax.swing.JPanel Container;
    private javax.swing.JPanel ConversationContainer;
    private javax.swing.JPanel ConversationContainer1;
    private javax.swing.JPanel ConversationLastMessageContainer;
    private javax.swing.JPanel ConversationLastMessageContainer1;
    private javax.swing.JLabel ConversationLastMessageDateLabel;
    private javax.swing.JLabel ConversationLastMessageDateLabel1;
    private javax.swing.JLabel ConversationLastMessageTextLabel;
    private javax.swing.JLabel ConversationLastMessageTextLabel1;
    private javax.swing.JLabel ConversationPicLabel;
    private javax.swing.JLabel ConversationPicLabel1;
    private javax.swing.JPanel ConversationPicPanel;
    private javax.swing.JPanel ConversationPicPanel1;
    private javax.swing.JButton CreatePostButton;
    private javax.swing.JButton GoToLoginScreenButton;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel HeaderHome;
    private javax.swing.JPanel HeaderMessages;
    private javax.swing.JPanel HeaderProfile;
    private javax.swing.JLabel HomeIcon;
    private javax.swing.JPanel HomeScreen;
    private javax.swing.JPanel HomeScreenContainer;
    private javax.swing.JPanel LoginScreen;
    private javax.swing.JPanel LoginScreenContainer;
    private javax.swing.JPanel LoginScreenContainer1;
    private javax.swing.JTextField LoginScreenEmailInput;
    private javax.swing.JLabel LoginScreenEmailInputLabel;
    private javax.swing.JLabel LoginScreenExceptionsLabel;
    private javax.swing.JButton LoginScreenLoginButton;
    private javax.swing.JPasswordField LoginScreenPasswordInput;
    private javax.swing.JLabel LoginScreenPasswordInputLabel;
    private javax.swing.JButton LoginScreenRegisterButton;
    private javax.swing.JLabel LoginScreenRegisterLabel;
    private javax.swing.JLabel LoginScreenTitle;
    private javax.swing.JLabel MessagesIcon;
    private javax.swing.JPanel MessagesScreen;
    private javax.swing.JButton NewPostButton;
    private javax.swing.JPanel NewPostScreen;
    private javax.swing.JTextField NewPostScreenAbsoluteFilePathValue;
    private javax.swing.JTextField NewPostScreenCaptionInput;
    private javax.swing.JLabel NewPostScreenCaptionLabel;
    private javax.swing.JPanel NewPostScreenContainer;
    private javax.swing.JLabel NewPostScreenExceptionsLabel;
    private javax.swing.JButton NewPostScreenPicChooseButton;
    private javax.swing.JLabel NewPostScreenPicLabel;
    private javax.swing.JPanel Post;
    private javax.swing.JLabel PostCaptionLabel;
    private javax.swing.JLabel PostDateLabel;
    private javax.swing.JLabel PostPictureLabel;
    private javax.swing.JPanel PostPicturePanel;
    private javax.swing.JLabel ProfileIcon;
    private javax.swing.JPanel ProfileScreen;
    private javax.swing.JLabel ProfileScreenAliasLabel;
    private javax.swing.JTextField ProfileScreenAlterAliasInput;
    private javax.swing.JLabel ProfileScreenAlterAliasLabel;
    private javax.swing.JTextField ProfileScreenAlterBioInput;
    private javax.swing.JLabel ProfileScreenAlterBioLabel;
    private javax.swing.JPasswordField ProfileScreenAlterConfirmpasswordInput;
    private javax.swing.JLabel ProfileScreenAlterConfirmpasswordLabel;
    private javax.swing.JTextField ProfileScreenAlterEmailInput;
    private javax.swing.JLabel ProfileScreenAlterEmailLabel;
    private javax.swing.JButton ProfileScreenAlterGeneralDataButton;
    private javax.swing.JLabel ProfileScreenAlterGeneralDataTitle;
    private javax.swing.JTextField ProfileScreenAlterNameInput;
    private javax.swing.JLabel ProfileScreenAlterNameLabel;
    private javax.swing.JButton ProfileScreenAlterPasswordButton;
    private javax.swing.JPasswordField ProfileScreenAlterPasswordInput;
    private javax.swing.JLabel ProfileScreenAlterPasswordLabel;
    private javax.swing.JLabel ProfileScreenAlterPasswordTitle;
    private javax.swing.JLabel ProfileScreenBioLabel;
    private javax.swing.JPanel ProfileScreenContainer;
    private javax.swing.JLabel ProfileScreenEmailLabel;
    private javax.swing.JLabel ProfileScreenExceptionsLabel;
    private javax.swing.JPanel ProfileScreenModifyUserContainer;
    private javax.swing.JPanel ProfileScreenUserInfoContainer;
    private javax.swing.JLabel ProfileScreenUsernameLabel;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JPanel RegisterScreen;
    private javax.swing.JTextField RegisterScreenAliasInput;
    private javax.swing.JLabel RegisterScreenAliasInputLabel;
    private javax.swing.JLabel RegisterScreenConfirmpasswordInputLabel;
    private javax.swing.JPanel RegisterScreenContainer;
    private javax.swing.JTextField RegisterScreenEmailInput;
    private javax.swing.JLabel RegisterScreenEmailInputLabel;
    private javax.swing.JLabel RegisterScreenExceptionsLabel;
    private javax.swing.JTextField RegisterScreenNameInput;
    private javax.swing.JLabel RegisterScreenNameInputLabel;
    private javax.swing.JPasswordField RegisterScreenPasswordConfirmInput;
    private javax.swing.JPasswordField RegisterScreenPasswordInput;
    private javax.swing.JLabel RegisterScreenPasswordInputLabel;
    private javax.swing.JLabel RegisterScreenTitle;
    private javax.swing.JTabbedPane Screens;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
