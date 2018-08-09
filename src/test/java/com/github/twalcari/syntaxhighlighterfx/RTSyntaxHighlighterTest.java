package com.github.twalcari.syntaxhighlighterfx;
/**
 * User: twalcari
 * Date: 6/12/2015
 * Time: 10:35
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.fxmisc.richtext.CodeArea;

public class RTSyntaxHighlighterTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private boolean isText1Visible = true;

    @Override
    public void start(Stage primaryStage) {


        CodeArea codeArea = new CodeArea(TEXT);
        codeArea.setPrefSize(800, 600);

        RTSyntaxHighlighter xmlCodeHighlighter = new RTSyntaxHighlighter(codeArea, "xml");


        BorderPane content = new BorderPane(codeArea);

        Button button = new Button("Change text");
        button.setOnAction(event -> {
            codeArea.replaceText(isText1Visible ? TEXT_2 : TEXT);
            isText1Visible = !isText1Visible;
        });
        content.setBottom(button);


        Scene scene = new Scene(content);

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

    private static final String TEXT_2 =
            "<rspec generated=\"2015-06-12T17:25:16.792+02:00\"\n" +
                    "    generated_by=\"jFed RSpec Editor\" type=\"manifest\"\n" +
                    "    xmlns=\"http://www.geni.net/resources/rspec/3\"\n" +
                    "    xmlns:client=\"http://www.protogeni.net/resources/rspec/ext/client/1\"\n" +
                    "    xmlns:delay=\"http://www.protogeni.net/resources/rspec/ext/delay/1\"\n" +
                    "    xmlns:emulab=\"http://www.protogeni.net/resources/rspec/ext/emulab/1\"\n" +
                    "    xmlns:jfed=\"http://jfed.iminds.be/rspec/ext/jfed/1\"\n" +
                    "    xmlns:jfed-command=\"http://jfed.iminds.be/rspec/ext/jfed-command/1\"\n" +
                    "    xmlns:jfed-ssh-keys=\"http://jfed.iminds.be/rspec/ext/jfed-ssh-keys/1\"\n" +
                    "    xmlns:jfedBonfire=\"http://jfed.iminds.be/rspec/ext/jfed-bonfire/1\"\n" +
                    "    xmlns:sharedvlan=\"http://www.protogeni.net/resources/rspec/ext/shared-vlan/1\"\n" +
                    "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.geni.net/resources/rspec/3 http://www.geni.net/resources/rspec/3/request.xsd \">\n" +
                    "    <node client_id=\"node0\"\n" +
                    "        component_id=\"urn:publicid:IDN+wall2.ilabt.iminds.be+node+n091-01\"\n" +
                    "        component_manager_id=\"urn:publicid:IDN+wall2.ilabt.iminds.be+authority+cm\"\n" +
                    "        exclusive=\"false\" sliver_id=\"urn:publicid:IDN+wall2.ilabt.iminds.be+sliver+64157\">\n" +
                    "        <sliver_type name=\"emulab-xen\"/>\n" +
                    "        <services>\n" +
                    "            <login authentication=\"ssh-keys\"\n" +
                    "                hostname=\"n091-vm01-2.wall2.ilabt.iminds.be\" port=\"22\" username=\"twalcari\"/>\n" +
                    "        </services>\n" +
                    "        <location x=\"134.0\"\n" +
                    "            xmlns=\"http://jfed.iminds.be/rspec/ext/jfed/1\" y=\"98.5\"/>\n" +
                    "        <interface client_id=\"node0:if0\"\n" +
                    "            component_id=\"urn:publicid:IDN+wall2.ilabt.iminds.be+interface+n091-01:lo0\"\n" +
                    "            mac_address=\"02ed052451de\" sliver_id=\"urn:publicid:IDN+wall2.ilabt.iminds.be+sliver+64161\">\n" +
                    "            <ip address=\"192.168.0.1\" netmask=\"255.255.255.0\" type=\"ipv4\"/>\n" +
                    "        </interface>\n" +
                    "        <emulab:vnode name=\"n091-vm01-2\"/>\n" +
                    "        <host name=\"node0.twalc4.wall2-ilabt-iminds-be.wall2.ilabt.iminds.be\"/>\n" +
                    "    </node>\n" +
                    "    <node client_id=\"node1\"\n" +
                    "        component_id=\"urn:publicid:IDN+wall2.ilabt.iminds.be+node+n091-01\"\n" +
                    "        component_manager_id=\"urn:publicid:IDN+wall2.ilabt.iminds.be+authority+cm\"\n" +
                    "        exclusive=\"false\" sliver_id=\"urn:publicid:IDN+wall2.ilabt.iminds.be+sliver+64158\">\n" +
                    "        <sliver_type name=\"emulab-xen\"/>\n" +
                    "        <services>\n" +
                    "            <login authentication=\"ssh-keys\"\n" +
                    "                hostname=\"n091-vm01-4.wall2.ilabt.iminds.be\" port=\"22\" username=\"twalcari\"/>\n" +
                    "        </services>\n" +
                    "        <location x=\"175.0\"\n" +
                    "            xmlns=\"http://jfed.iminds.be/rspec/ext/jfed/1\" y=\"242.5\"/>\n" +
                    "        <interface client_id=\"node1:if0\"\n" +
                    "            component_id=\"urn:publicid:IDN+wall2.ilabt.iminds.be+interface+n091-01:lo0\"\n" +
                    "            mac_address=\"02bcba641360\" sliver_id=\"urn:publicid:IDN+wall2.ilabt.iminds.be+sliver+64162\">\n" +
                    "            <ip address=\"192.168.0.2\" netmask=\"255.255.255.0\" type=\"ipv4\"/>\n" +
                    "        </interface>\n" +
                    "        <emulab:vnode name=\"n091-vm01-4\"/>\n" +
                    "        <host name=\"node1.twalc4.wall2-ilabt-iminds-be.wall2.ilabt.iminds.be\"/>\n" +
                    "    </node>\n" +
                    "    <link client_id=\"link0\" sliver_id=\"urn:publicid:IDN+wall2.ilabt.iminds.be+sliver+64160\">\n" +
                    "        <component_manager name=\"urn:publicid:IDN+wall2.ilabt.iminds.be+authority+cm\"/>\n" +
                    "        <interface_ref client_id=\"node0:if0\"\n" +
                    "            component_id=\"urn:publicid:IDN+wall2.ilabt.iminds.be+interface+n091-01:lo0\" sliver_id=\"urn:publicid:IDN+wall2.ilabt.iminds.be+sliver+64161\"/>\n" +
                    "        <interface_ref client_id=\"node1:if0\"\n" +
                    "            component_id=\"urn:publicid:IDN+wall2.ilabt.iminds.be+interface+n091-01:lo0\" sliver_id=\"urn:publicid:IDN+wall2.ilabt.iminds.be+sliver+64162\"/>\n" +
                    "        <link_type name=\"lan\"/>\n" +
                    "    </link>\n" +
                    "</rspec>\n";
}
