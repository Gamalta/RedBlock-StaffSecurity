package fr.gamalta.redblock.staffsecurity.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import fr.gamalta.redblock.staffsecurity.StaffSecurity;

public class Utils {

	StaffSecurity main;

	public Utils(StaffSecurity main) {
		this.main = main;
	}

	public void sendEmail(User user) {

		String token = user.getToken();
		String from = "gamalta@redblock.fr";
		String host = main.settingsCFG.getString("Staff.Mail.Host");

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		Session session = Session.getInstance(props);

		try {

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
			msg.setSubject(main.settingsCFG.getString("Staff.Mail.Title"));
			msg.setSentDate(new Date());
			msg.setText(main.settingsCFG.getString("Staff.Mail.Message").replace("%token%", token));
			Transport.send(msg);

		} catch (MessagingException mex) {

			main.dataCFG.set("Staff." + user.getPlayer().getUniqueId().toString(), null);
			main.players.add(user);
		}
	}

	public void kickTask() {
		// TODO Auto-generated method stub

	}
}
