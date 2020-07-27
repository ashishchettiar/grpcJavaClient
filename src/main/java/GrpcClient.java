import com.fun.grpcExample.User;
import com.fun.grpcExample.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class GrpcClient {
    public static void main(String[] args)
    {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        //stubs - generate from proto file
        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        User.LoginRequest login = User.LoginRequest.newBuilder()
                .setUsername("user").setPassword("user").build();

       User.APIResponse response = userStub.login(login);
       System.out.println(response.getResponseMessage());
    }
}
