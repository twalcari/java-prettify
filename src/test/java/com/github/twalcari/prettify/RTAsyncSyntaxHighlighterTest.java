package com.github.twalcari.prettify;/**
 * User: twalcari
 * Date: 6/12/2015
 * Time: 10:35
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.fxmisc.richtext.CodeArea;

public class RTAsyncSyntaxHighlighterTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        CodeArea codeArea = new CodeArea(TEXT);
        codeArea.setPrefSize(800,600);

        RTAsyncSyntaxHighlighter xmlCodeHighlighter = new RTAsyncSyntaxHighlighter(codeArea, "xml");

        Scene scene = new Scene(codeArea);

        primaryStage.setScene(scene);

        primaryStage.show();


    }

    private static final String TEXT = "<!--\n" +
            "    RSpec for ProtoGENI backbone demo, GEC6, November 16, 2009\n" +
            "    Contains an access point in Utah, a server in the Washington, DC POP,\n" +
            "    and hops through a series of NetFPGAs in between.\n" +
            "-->\n" +
            "<rspec type=\"request\" xmlns=\"http://www.protogeni.net/resources/rspec/0.1\">\n" +
            "\n" +
            "    <!--\n" +
            "        Request that this slice last through November 18\n" +
            "    -->\n" +
            "    <valid_until>20091118T22:00:00</valid_until>\n" +
            "\n" +
            "    <!--\n" +
            "        AP in the stadium: pcwf141\n" +
            "    -->\n" +
            "  <node component_uuid=\"urn:publicid:IDN+emulab.net+node+pcwf141\" component_manager_uuid=\"urn:publicid:IDN+emulab.net+authority+cm\" virtual_id=\"ap\" virtualization_type=\"emulab-vnode\" exclusive=\"1\">\n" +
            "    <node_type type_name=\"pc\" type_slots=\"1\"/>\n" +
            "    <!-- Note that we declare an interface here; below, we'll reference this\n" +
            "         interface when we make a LAN -->\n" +
            "    <interface virtual_id=\"virt-0\"/>\n" +
            "  </node>\n" +
            "\n" +
            "  <!--\n" +
            "       Webserver in DC POP: pg41\n" +
            "  -->\n" +
            "  <node component_uuid=\"urn:publicid:IDN+emulab.net+node+pg41\" component_manager_uuid=\"urn:publicid:IDN+emulab.net+authority+cm\" virtual_id=\"server\" virtualization_type=\"emulab-vnode\" exclusive=\"1\">\n" +
            "    <node_type type_name=\"pcpg-i2\" type_slots=\"1\"/>\n" +
            "    <interface virtual_id=\"virt-0\"/>\n" +
            "  </node>\n" +
            "\n" +
            "  <!--\n" +
            "      Machine in Emulab to send router advertisements, which act as the IPv6\n" +
            "      equivalent of DHCP for our purposes.\n" +
            "      Note that the component_uuid is blank: This lets the component manager\n" +
            "      select a node for us.\n" +
            "   -->\n" +
            "  <node component_manager_uuid=\"urn:publicid:IDN+emulab.net+authority+cm\" virtual_id=\"nd\" virtualization_type=\"emulab-vnode\" exclusive=\"1\">\n" +
            "    <node_type type_name=\"pc\" type_slots=\"1\"/>\n" +
            "    <interface virtual_id=\"virt-0\"/>\n" +
            "  </node>\n" +
            "\n" +
            "  <!--\n" +
            "      netfpga and host in SALT POP\n" +
            "  -->\n" +
            "  <node component_uuid=\"urn:publicid:IDN+emulab.net+node+pg44\" component_manager_uuid=\"urn:publicid:IDN+emulab.net+authority+cm\" virtual_id=\"nfhost-salt\" virtualization_type=\"emulab-vnode\" exclusive=\"1\">\n" +
            "    <node_type type_name=\"pc\" type_slots=\"1\"/>\n" +
            "  </node>\n" +
            "  <node component_uuid=\"urn:publicid:IDN+emulab.net+node+netfpga18\" component_manager_uuid=\"urn:publicid:IDN+emulab.net+authority+cm\" virtual_id=\"nf-salt\" virtualization_type=\"emulab-vnode\" exclusive=\"1\">\n" +
            "    <node_type type_name=\"netfpga2\" type_slots=\"1\"/>\n" +
            "    <!-- Note that the NetFPGA is declared as a 'subnode' of the PC that hosts\n" +
            "         it. In an advertisement, we use the virtual ID of the host machine -->\n" +
            "    <subnode_of>nfhost-salt</subnode_of>\n" +
            "    <interface virtual_id=\"virt-0\"/>\n" +
            "    <interface virtual_id=\"virt-1\"/>\n" +
            "  </node>\n" +
            "\n" +
            "  <!--\n" +
            "      netfpga and host in KANS POP\n" +
            "  -->\n" +
            "  <node component_uuid=\"urn:publicid:IDN+emulab.net+node+pg42\" component_manager_uuid=\"urn:publicid:IDN+emulab.net+authority+cm\" virtual_id=\"nfhost-kans\" virtualization_type=\"emulab-vnode\" exclusive=\"1\">\n" +
            "    <node_type type_name=\"pc\" type_slots=\"1\"/>\n" +
            "  </node>\n" +
            "  <node component_uuid=\"urn:publicid:IDN+emulab.net+node+netfpga14\" component_manager_uuid=\"urn:publicid:IDN+emulab.net+authority+cm\" virtual_id=\"nf-kans\" virtualization_type=\"emulab-vnode\" exclusive=\"1\">\n" +
            "    <node_type type_name=\"netfpga2\" type_slots=\"1\"/>\n" +
            "    <subnode_of>nfhost-kans</subnode_of>\n" +
            "    <interface virtual_id=\"virt-0\"/>\n" +
            "    <interface virtual_id=\"virt-1\"/>\n" +
            "  </node>\n" +
            "\n" +
            "  <!--\n" +
            "      netfpga and host in WASH POP\n" +
            "  -->\n" +
            "  <node component_uuid=\"urn:publicid:IDN+emulab.net+node+pg40\" component_manager_uuid=\"urn:publicid:IDN+emulab.net+authority+cm\" virtual_id=\"nfhost-wash\" virtualization_type=\"emulab-vnode\" exclusive=\"1\">\n" +
            "    <node_type type_name=\"pc\" type_slots=\"1\"/>\n" +
            "  </node>\n" +
            "  <node component_uuid=\"urn:publicid:IDN+emulab.net+node+netfpga10\" component_manager_uuid=\"urn:publicid:IDN+emulab.net+authority+cm\" virtual_id=\"nf-wash\" virtualization_type=\"emulab-vnode\" exclusive=\"1\">\n" +
            "    <node_type type_name=\"netfpga2\" type_slots=\"1\"/>\n" +
            "    <subnode_of>nfhost-wash</subnode_of>\n" +
            "    <interface virtual_id=\"virt-0\"/>\n" +
            "    <interface virtual_id=\"virt-1\"/>\n" +
            "  </node>\n" +
            "\n" +
            "  <!--\n" +
            "      LAN containing AP, neighbor discovery server, and the first-hop\n" +
            "      NetFPGA in the SALT POP\n" +
            "  -->\n" +
            "  <link virtual_id=\"ap-link\" link_type=\"ethernet\">\n" +
            "    <!-- Note that these are references to interface declared above.\n" +
            "         A LAN is simply a link that contains more than two interfaces -->\n" +
            "    <interface_ref virtual_node_id=\"nd\" virtual_interface_id=\"virt-0\"/>\n" +
            "    <interface_ref virtual_node_id=\"ap\" virtual_interface_id=\"virt-0\"/>\n" +
            "    <interface_ref virtual_node_id=\"nf-salt\" virtual_interface_id=\"virt-0\"/>\n" +
            "    <bandwidth>1000000</bandwidth>\n" +
            "  </link>\n" +
            "\n" +
            "  <!--\n" +
            "      Hop from SALT to KANS\n" +
            "  -->\n" +
            "  <link virtual_id=\"salt-kans-link\" link_type=\"ethernet\">\n" +
            "    <interface_ref virtual_node_id=\"nf-salt\" virtual_interface_id=\"virt-1\"/>\n" +
            "    <interface_ref virtual_node_id=\"nf-kans\" virtual_interface_id=\"virt-0\"/>\n" +
            "    <bandwidth>1000000</bandwidth>\n" +
            "  </link>\n" +
            "\n" +
            "  <!--\n" +
            "      Hop from KANS to WASH\n" +
            "  -->\n" +
            "  <link virtual_id=\"kans-wash-link\" link_type=\"ethernet\">\n" +
            "    <interface_ref virtual_node_id=\"nf-kans\" virtual_interface_id=\"virt-1\"/>\n" +
            "    <interface_ref virtual_node_id=\"nf-wash\" virtual_interface_id=\"virt-0\"/>\n" +
            "    <bandwidth>1000000</bandwidth>\n" +
            "  </link>\n" +
            "\n" +
            "  <!--\n" +
            "      Final hop from NetFPGA to server\n" +
            "  -->\n" +
            "  <link virtual_id=\"server-link\" link_type=\"ethernet\">\n" +
            "    <interface_ref virtual_node_id=\"nf-wash\" virtual_interface_id=\"virt-1\"/>\n" +
            "    <interface_ref virtual_node_id=\"server\" virtual_interface_id=\"virt-0\"/>\n" +
            "    <bandwidth>1000000</bandwidth>\n" +
            "  </link>\n" +
            "\n" +
            "</rspec>";
}
