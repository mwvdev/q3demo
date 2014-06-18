package mwvdev.quake.loaders;

import mwvdev.quake.huffman.HuffmanReader;
import mwvdev.quake.models.ServerCommand;

public class ServerCommandLoader
{

    public ServerCommand loadServerCommand( HuffmanReader huffmanReader )
    {
        ServerCommand serverCommand = new ServerCommand();

        serverCommand.setIndex( huffmanReader.readInt() );
        serverCommand.setCommand( huffmanReader.readString() );

        return serverCommand;
    }

}
