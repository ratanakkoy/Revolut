package ratanak.revolutTransfers.web;

import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import ratanak.revolutTransfers.dao.AccountDAO;
import ratanak.revolutTransfers.model.Account;

@Path("accounts")
public class AccountResource {

	@Context
	UriInfo uriInfo;

	@HEAD
	public Response testConnection() {
		return Response.ok().build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> getAllAccounts() throws NamingException {
		AccountDAO accountDAO = new AccountDAO();
		List<Account> accounts = accountDAO.getAccounts();
		return accounts;
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Account getAccount(@PathParam("id") int id) throws NamingException {
		AccountDAO accountDAO = new AccountDAO();
		Account account = accountDAO.getAccount(id);
		return account;
	}

	@POST
	@Path("{accountNumber}")
	public Response createAccount(@PathParam("accountNumber") String accountNumber) throws NamingException {
		AccountDAO accountDAO = new AccountDAO();
		accountDAO.createAccount(accountNumber);
		return Response.created(uriInfo.getAbsolutePath()).build();
	}
}
