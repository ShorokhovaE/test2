package ru.gb.file.gb_cloud;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import ru.gb.file.gb_cloud.dto.BasicResponse;
import ru.gb.file.gb_cloud.dto.LoadFileRequest;
import java.io.FileOutputStream;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    PrimaryController pr;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        BasicResponse response = (BasicResponse) msg;
        System.out.println(response.getResponse());
        String responseText = response.getResponse();
        pr = (PrimaryController) ControllerRegistry.getControllerObject(PrimaryController.class);

        if("login_ok".equals(responseText)){
//            PrimaryController pr =
//                    (PrimaryController) ControllerRegistry.getControllerObject(PrimaryController.class);
            pr.loginOk();
        } if("login_no".equals(responseText)){
//            PrimaryController pr =
//                    (PrimaryController) ControllerRegistry.getControllerObject(PrimaryController.class);
            pr.loginNo();
        } if("reg_no".equals(responseText)){
//            PrimaryController pr =
//                    (PrimaryController) ControllerRegistry.getControllerObject(PrimaryController.class);
            pr.regNo();
        }if("log_off".equals(responseText)){
            System.out.println("Клиент вышел");
        } if("download_ok".equals(responseText)) {
            System.out.println("Скачивание файла");
//            LocalFilePanelController localPanel =
//                    (LocalFilePanelController) ControllerRegistry.getControllerObject(LocalFilePanelController.class);
//            String path = String.format(localPanel.pathField.getText() +"/%s", response.getFile().getName());
            String pathOfFile = String.format("./%s", response.getFileName());
            FileOutputStream fos = new FileOutputStream(pathOfFile);
            fos.write((response).getData());
        }

//        if ("file list....".equals(responseText)) {
//            ctx.close();
//            return;
//        }
//        ctx.writeAndFlush(new GetFileListRequest());
    }


}
