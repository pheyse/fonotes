package com.bright_side_it.fonotes.common.presenter;

import generated.fliesenui.core.FLUIClientPropertiesDTO;
import generated.fliesenui.dto.OverviewParameterDTO;
import generated.fliesenui.screen.AboutListener;
import generated.fliesenui.screen.AboutReply;

public class AboutPresenter implements AboutListener{
	
	@Override
	public void onInputDialogResult(AboutReply reply, String referenceID, String dialogResult) {
	}

	@Override
	public void onConfirmDialogResult(AboutReply reply, String referenceID, boolean confirmed) {
	}

	@Override
	public void onLoaded(AboutReply reply, FLUIClientPropertiesDTO clientProperties, OverviewParameterDTO parameter) {
		reply.setAboutTextText(createAboutText());		
	}

	private String createAboutText() {
		StringBuilder sb = new StringBuilder();
		sb.append("# Fonotes\n");
		sb.append("2016 by Philip Heyse - www.bright-side.de\n\n");
		sb.append("## Used libraries and licences:\n");
		sb.append(" - Fliesen UI: Apache V2\n");
		sb.append(" - GSON (https://github.com/google/gson): Apache V2\n");
		sb.append(" - Jetty (http://www.eclipse.org/jetty/): Apache V2\n");
		sb.append(" - Showdown: see below\n");
		sb.append("\n\n\n");
		sb.append("## Showdown license:\n");
		sb.append("```\n");
		sb.append("Showdown Copyright (c) 2007, John Fraser\n");
		sb.append("<http://www.attacklab.net/>\n");
		sb.append("All rights reserved.\n");
		sb.append("Original Markdown copyright (c) 2004, John Gruber\n");
		sb.append("<http://daringfireball.net/>\n");
		sb.append("All rights reserved.\n");
		sb.append("Redistribution and use in source and binary forms, with or without\n");
		sb.append("modification, are permitted provided that the following conditions are\n");
		sb.append("met:\n");
		sb.append("* Redistributions of source code must retain the above copyright notice,\n");
		sb.append("  this list of conditions and the following disclaimer.\n");
		sb.append("* Redistributions in binary form must reproduce the above copyright\n");
		sb.append("  notice, this list of conditions and the following disclaimer in the\n");
		sb.append("  documentation and/or other materials provided with the distribution.\n");
		sb.append("* Neither the name \"Markdown\" nor the names of its contributors may\n");
		sb.append("  be used to endorse or promote products derived from this software\n");
		sb.append("  without specific prior written permission.\n");
		sb.append("This software is provided by the copyright holders and contributors \"as\n");
		sb.append("is\" and any express or implied warranties, including, but not limited\n");
		sb.append("to, the implied warranties of merchantability and fitness for a\n");
		sb.append("particular purpose are disclaimed. In no event shall the copyright owner\n");
		sb.append("or contributors be liable for any direct, indirect, incidental, special,\n");
		sb.append("exemplary, or consequential damages (including, but not limited to,\n");
		sb.append("procurement of substitute goods or services; loss of use, data, or\n");
		sb.append("profits; or business interruption) however caused and on any theory of\n");
		sb.append("liability, whether in contract, strict liability, or tort (including\n");
		sb.append("negligence or otherwise) arising in any way out of the use of this\n");
		sb.append("software, even if advised of the possibility of such damage.\n");
		sb.append("\n\n\n");
		sb.append("```\n");
		sb.append("## Apache V2:\n");
		sb.append("```\n");
		sb.append("                                 Apache License\n");
		sb.append("                           Version 2.0, January 2004\n");
		sb.append("                        http://www.apache.org/licenses/\n");
		sb.append("   TERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION\n");
		sb.append("   1. Definitions.\n");
		sb.append("      \"License\" shall mean the terms and conditions for use, reproduction,\n");
		sb.append("      and distribution as defined by Sections 1 through 9 of this document.\n");
		sb.append("      \"Licensor\" shall mean the copyright owner or entity authorized by\n");
		sb.append("      the copyright owner that is granting the License.\n");
		sb.append("      \"Legal Entity\" shall mean the union of the acting entity and all\n");
		sb.append("      other entities that control, are controlled by, or are under common\n");
		sb.append("      control with that entity. For the purposes of this definition,\n");
		sb.append("      \"control\" means (i) the power, direct or indirect, to cause the\n");
		sb.append("      direction or management of such entity, whether by contract or\n");
		sb.append("      otherwise, or (ii) ownership of fifty percent (50%) or more of the\n");
		sb.append("      outstanding shares, or (iii) beneficial ownership of such entity.\n");
		sb.append("      \"You\" (or \"Your\") shall mean an individual or Legal Entity\n");
		sb.append("      exercising permissions granted by this License.\n");
		sb.append("      \"Source\" form shall mean the preferred form for making modifications,\n");
		sb.append("      including but not limited to software source code, documentation\n");
		sb.append("      source, and configuration files.\n");
		sb.append("      \"Object\" form shall mean any form resulting from mechanical\n");
		sb.append("      transformation or translation of a Source form, including but\n");
		sb.append("      not limited to compiled object code, generated documentation,\n");
		sb.append("      and conversions to other media types.\n");
		sb.append("      \"Work\" shall mean the work of authorship, whether in Source or\n");
		sb.append("      Object form, made available under the License, as indicated by a\n");
		sb.append("      copyright notice that is included in or attached to the work\n");
		sb.append("      (an example is provided in the Appendix below).\n");
		sb.append("      \"Derivative Works\" shall mean any work, whether in Source or Object\n");
		sb.append("      form, that is based on (or derived from) the Work and for which the\n");
		sb.append("      editorial revisions, annotations, elaborations, or other modifications\n");
		sb.append("      represent, as a whole, an original work of authorship. For the purposes\n");
		sb.append("      of this License, Derivative Works shall not include works that remain\n");
		sb.append("      separable from, or merely link (or bind by name) to the interfaces of,\n");
		sb.append("      the Work and Derivative Works thereof.\n");
		sb.append("      \"Contribution\" shall mean any work of authorship, including\n");
		sb.append("      the original version of the Work and any modifications or additions\n");
		sb.append("      to that Work or Derivative Works thereof, that is intentionally\n");
		sb.append("      submitted to Licensor for inclusion in the Work by the copyright owner\n");
		sb.append("      or by an individual or Legal Entity authorized to submit on behalf of\n");
		sb.append("      the copyright owner. For the purposes of this definition, \"submitted\"\n");
		sb.append("      means any form of electronic, verbal, or written communication sent\n");
		sb.append("      to the Licensor or its representatives, including but not limited to\n");
		sb.append("      communication on electronic mailing lists, source code control systems,\n");
		sb.append("      and issue tracking systems that are managed by, or on behalf of, the\n");
		sb.append("      Licensor for the purpose of discussing and improving the Work, but\n");
		sb.append("      excluding communication that is conspicuously marked or otherwise\n");
		sb.append("      designated in writing by the copyright owner as \"Not a Contribution.\"\n");
		sb.append("      \"Contributor\" shall mean Licensor and any individual or Legal Entity\n");
		sb.append("      on behalf of whom a Contribution has been received by Licensor and\n");
		sb.append("      subsequently incorporated within the Work.\n");
		sb.append("   2. Grant of Copyright License. Subject to the terms and conditions of\n");
		sb.append("      this License, each Contributor hereby grants to You a perpetual,\n");
		sb.append("      worldwide, non-exclusive, no-charge, royalty-free, irrevocable\n");
		sb.append("      copyright license to reproduce, prepare Derivative Works of,\n");
		sb.append("      publicly display, publicly perform, sublicense, and distribute the\n");
		sb.append("      Work and such Derivative Works in Source or Object form.\n");
		sb.append("   3. Grant of Patent License. Subject to the terms and conditions of\n");
		sb.append("      this License, each Contributor hereby grants to You a perpetual,\n");
		sb.append("      worldwide, non-exclusive, no-charge, royalty-free, irrevocable\n");
		sb.append("      (except as stated in this section) patent license to make, have made,\n");
		sb.append("      use, offer to sell, sell, import, and otherwise transfer the Work,\n");
		sb.append("      where such license applies only to those patent claims licensable\n");
		sb.append("      by such Contributor that are necessarily infringed by their\n");
		sb.append("      Contribution(s) alone or by combination of their Contribution(s)\n");
		sb.append("      with the Work to which such Contribution(s) was submitted. If You\n");
		sb.append("      institute patent litigation against any entity (including a\n");
		sb.append("      cross-claim or counterclaim in a lawsuit) alleging that the Work\n");
		sb.append("      or a Contribution incorporated within the Work constitutes direct\n");
		sb.append("      or contributory patent infringement, then any patent licenses\n");
		sb.append("      granted to You under this License for that Work shall terminate\n");
		sb.append("      as of the date such litigation is filed.\n");
		sb.append("   4. Redistribution. You may reproduce and distribute copies of the\n");
		sb.append("      Work or Derivative Works thereof in any medium, with or without\n");
		sb.append("      modifications, and in Source or Object form, provided that You\n");
		sb.append("      meet the following conditions:\n");
		sb.append("      (a) You must give any other recipients of the Work or\n");
		sb.append("          Derivative Works a copy of this License; and\n");
		sb.append("      (b) You must cause any modified files to carry prominent notices\n");
		sb.append("          stating that You changed the files; and\n");
		sb.append("      (c) You must retain, in the Source form of any Derivative Works\n");
		sb.append("          that You distribute, all copyright, patent, trademark, and\n");
		sb.append("          attribution notices from the Source form of the Work,\n");
		sb.append("          excluding those notices that do not pertain to any part of\n");
		sb.append("          the Derivative Works; and\n");
		sb.append("      (d) If the Work includes a \"NOTICE\" text file as part of its\n");
		sb.append("          distribution, then any Derivative Works that You distribute must\n");
		sb.append("          include a readable copy of the attribution notices contained\n");
		sb.append("          within such NOTICE file, excluding those notices that do not\n");
		sb.append("          pertain to any part of the Derivative Works, in at least one\n");
		sb.append("          of the following places: within a NOTICE text file distributed\n");
		sb.append("          as part of the Derivative Works; within the Source form or\n");
		sb.append("          documentation, if provided along with the Derivative Works; or,\n");
		sb.append("          within a display generated by the Derivative Works, if and\n");
		sb.append("          wherever such third-party notices normally appear. The contents\n");
		sb.append("          of the NOTICE file are for informational purposes only and\n");
		sb.append("          do not modify the License. You may add Your own attribution\n");
		sb.append("          notices within Derivative Works that You distribute, alongside\n");
		sb.append("          or as an addendum to the NOTICE text from the Work, provided\n");
		sb.append("          that such additional attribution notices cannot be construed\n");
		sb.append("          as modifying the License.\n");
		sb.append("      You may add Your own copyright statement to Your modifications and\n");
		sb.append("      may provide additional or different license terms and conditions\n");
		sb.append("      for use, reproduction, or distribution of Your modifications, or\n");
		sb.append("      for any such Derivative Works as a whole, provided Your use,\n");
		sb.append("      reproduction, and distribution of the Work otherwise complies with\n");
		sb.append("      the conditions stated in this License.\n");
		sb.append("   5. Submission of Contributions. Unless You explicitly state otherwise,\n");
		sb.append("      any Contribution intentionally submitted for inclusion in the Work\n");
		sb.append("      by You to the Licensor shall be under the terms and conditions of\n");
		sb.append("      this License, without any additional terms or conditions.\n");
		sb.append("      Notwithstanding the above, nothing herein shall supersede or modify\n");
		sb.append("      the terms of any separate license agreement you may have executed\n");
		sb.append("      with Licensor regarding such Contributions.\n");
		sb.append("   6. Trademarks. This License does not grant permission to use the trade\n");
		sb.append("      names, trademarks, service marks, or product names of the Licensor,\n");
		sb.append("      except as required for reasonable and customary use in describing the\n");
		sb.append("      origin of the Work and reproducing the content of the NOTICE file.\n");
		sb.append("   7. Disclaimer of Warranty. Unless required by applicable law or\n");
		sb.append("      agreed to in writing, Licensor provides the Work (and each\n");
		sb.append("      Contributor provides its Contributions) on an \"AS IS\" BASIS,\n");
		sb.append("      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or\n");
		sb.append("      implied, including, without limitation, any warranties or conditions\n");
		sb.append("      of TITLE, NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A\n");
		sb.append("      PARTICULAR PURPOSE. You are solely responsible for determining the\n");
		sb.append("      appropriateness of using or redistributing the Work and assume any\n");
		sb.append("      risks associated with Your exercise of permissions under this License.\n");
		sb.append("   8. Limitation of Liability. In no event and under no legal theory,\n");
		sb.append("      whether in tort (including negligence), contract, or otherwise,\n");
		sb.append("      unless required by applicable law (such as deliberate and grossly\n");
		sb.append("      negligent acts) or agreed to in writing, shall any Contributor be\n");
		sb.append("      liable to You for damages, including any direct, indirect, special,\n");
		sb.append("      incidental, or consequential damages of any character arising as a\n");
		sb.append("      result of this License or out of the use or inability to use the\n");
		sb.append("      Work (including but not limited to damages for loss of goodwill,\n");
		sb.append("      work stoppage, computer failure or malfunction, or any and all\n");
		sb.append("      other commercial damages or losses), even if such Contributor\n");
		sb.append("      has been advised of the possibility of such damages.\n");
		sb.append("   9. Accepting Warranty or Additional Liability. While redistributing\n");
		sb.append("      the Work or Derivative Works thereof, You may choose to offer,\n");
		sb.append("      and charge a fee for, acceptance of support, warranty, indemnity,\n");
		sb.append("      or other liability obligations and/or rights consistent with this\n");
		sb.append("      License. However, in accepting such obligations, You may act only\n");
		sb.append("      on Your own behalf and on Your sole responsibility, not on behalf\n");
		sb.append("      of any other Contributor, and only if You agree to indemnify,\n");
		sb.append("      defend, and hold each Contributor harmless for any liability\n");
		sb.append("      incurred by, or claims asserted against, such Contributor by reason\n");
		sb.append("      of your accepting any such warranty or additional liability.\n");
		sb.append("   END OF TERMS AND CONDITIONS\n");
		sb.append("   APPENDIX: How to apply the Apache License to your work.\n");
		sb.append("      To apply the Apache License to your work, attach the following\n");
		sb.append("      boilerplate notice, with the fields enclosed by brackets \"[]\"\n");
		sb.append("      replaced with your own identifying information. (Don't include\n");
		sb.append("      the brackets!)  The text should be enclosed in the appropriate\n");
		sb.append("      comment syntax for the file format. We also recommend that a\n");
		sb.append("      file or class name and description of purpose be included on the\n");
		sb.append("      same \"printed page\" as the copyright notice for easier\n");
		sb.append("      identification within third-party archives.\n");
		sb.append("   Copyright [yyyy] [name of copyright owner]\n");
		sb.append("   Licensed under the Apache License, Version 2.0 (the \"License\");\n");
		sb.append("   you may not use this file except in compliance with the License.\n");
		sb.append("   You may obtain a copy of the License at\n");
		sb.append("       http://www.apache.org/licenses/LICENSE-2.0\n");
		sb.append("   Unless required by applicable law or agreed to in writing, software\n");
		sb.append("   distributed under the License is distributed on an \"AS IS\" BASIS,\n");
		sb.append("   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n");
		sb.append("   See the License for the specific language governing permissions and\n");
		sb.append("   limitations under the License.\n");
		sb.append("```\n");
		sb.append("\n\n\n");
		
		return sb.toString();
	}

	@Override
	public void onBackButtonClicked(AboutReply reply, OverviewParameterDTO parameter) {
		reply.openScreenOverview(parameter);
	}

}
