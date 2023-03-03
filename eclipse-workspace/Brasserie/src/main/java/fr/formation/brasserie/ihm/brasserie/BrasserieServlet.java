package fr.formation.brasserie.ihm.brasserie;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.brasserie.bll.BrasserieException;
import fr.formation.brasserie.bll.BrasserieManager;

import fr.formation.brasserie.bll.BrasserieSing;
import fr.formation.brasserie.bo.Biere;
import fr.formation.brasserie.bo.Brasserie;
import fr.formation.brasserie.dal.DALException;

/**
 * Servlet implementation class BrasserieServlet
 */
@WebServlet("/BrasserieServlet")
public class BrasserieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BrasserieManager manager = BrasserieSing.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrasserieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		BrasserieModel model = new BrasserieModel(new Brasserie(), "");
		BrasserieModel modelBi = new BrasserieModel(new Biere(), "");

		
		if (request.getParameter("BT_DELETEALL") != null) {
			try {
				actionDeleteAll(request);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// DELETE
		if (request.getParameter("BT_DELETE") != null) {
			try {
				actionDelete(request);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// REMONTER DE LA BRASSERIE SELECTIONNEE DANS LE FORMULAIRE
		if (request.getParameter("BT_MODIFY") != null) {
			actionModify(request, model);
		}

		// VALIDATION FORMULAIRE
		if (request.getParameter("BT_VALIDBR") != null) {
			initValidationBr(request, model);

			// CAS OU ON EST EN MODIFICATION
			if (!"".equals(request.getParameter("idModify"))) {
				try {
					modifyValidation(request, model);
				} catch (DALException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				// CAS OU ON EST EN INSERTION
				insertValidation(model);
			}
		}
		
		// BIERE
		
		if (request.getParameter("BT_DELETEALLBI") != null) {
			try {
				actionDeleteAllBi(request);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			if (request.getParameter("BT_DELETEBI") != null) {
				try {
					actionDeleteBi(request);
				} catch (DALException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// REMONTER DE LA BIERE SELECTIONNEE DANS LE FORMULAIRE
			if (request.getParameter("BT_MODIFYBI") != null) {
				actionModifyBi(request, modelBi);
			}

			// VALIDATION FORMULAIRE
			if (request.getParameter("BT_VALIDBI") != null) {
				initValidationBi(request, modelBi);

				// CAS OU ON EST EN MODIFICATION
				if (!"".equals(request.getParameter("idModify"))) {
					try {
						modifyValidationBi(request, modelBi);
					} catch (DALException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					// CAS OU ON EST EN INSERTION
					try {
						insertValidationBi(modelBi);
					} catch (DALException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		try {
			model.setLstBrasseries(manager.getAll());
			modelBi.setLstBieres(manager.getHistoryBiere());
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("model", model);
		request.setAttribute("modelBi", modelBi);
		request.getRequestDispatcher("/WEB-INF/brasserie.jsp").forward(request, response);

	}

	private void insertValidation(BrasserieModel model) {
		if (model.check() != null) {
			model.setErreur("ERREUR" + model.check());
		} else {
			try {
				manager.add(model.getCurrent());
			} catch (BrasserieException e) {
				model.setErreur("ERREUR" + e.getMessage());
			}
		}
	}

	private void modifyValidation(HttpServletRequest request, BrasserieModel model) throws DALException {
		model.getCurrent().setIdBrasserie(Long.parseLong(request.getParameter("idModify")));
		manager.modify(model.getCurrent());
	}

	private void initValidationBr(HttpServletRequest request, BrasserieModel model) {
		model.getCurrent().setNom(request.getParameter("nomBr"));
		model.getCurrent().setAdresse(request.getParameter("adresse"));
		model.getCurrent().setVille(request.getParameter("ville"));
	}

	private void actionModify(HttpServletRequest request, BrasserieModel model) {
		Long id = Long.parseLong(request.getParameter("BT_MODIFY"));
		Brasserie brasserie = manager.getById(id);
		model.setCurrent(brasserie);
		model.setIdModify(id);
	}

	private void actionDelete(HttpServletRequest request) throws DALException {
		Long id = Long.parseLong(request.getParameter("BT_DELETE"));
		manager.deleteBy(id);
	}
	private void actionDeleteAll(HttpServletRequest request) throws DALException {
		manager.deleteBr();
	}
	
	
	//Biere
	private void insertValidationBi(BrasserieModel model) throws DALException {
		if (model.checkBi() != null) {
			model.setErreur("ERREUR" + model.checkBi());
		} else {
			try {
				manager.ajoutBiere(model.getCurrentBi());
			} catch (BrasserieException e) {
				model.setErreur("ERREUR" + e.getMessage());
			}
		}
	}

	private void modifyValidationBi(HttpServletRequest request, BrasserieModel model) throws DALException {
		model.getCurrentBi().setId(Long.parseLong(request.getParameter("idModify")));
		manager.modify(model.getCurrentBi());
	}
	
	private void initValidationBi(HttpServletRequest request, BrasserieModel model) {
		model.getCurrentBi().setNom(request.getParameter("nomBi"));
		model.getCurrentBi().setType(request.getParameter("type"));
		model.getCurrentBi().setNote(Integer.parseInt(request.getParameter("note")));
		model.getCurrentBi().setDate(LocalDate.parse(request.getParameter("date")));
		model.getCurrentBi().setBrasserie(Long.parseLong(request.getParameter("brasserie")));

	}
	
	private void actionModifyBi(HttpServletRequest request, BrasserieModel model) {
		Long id = Long.parseLong(request.getParameter("BT_MODIFYBI"));
		Biere biere = manager.getByIdBi(id);
		model.setCurrentBi(biere);
		model.setIdModify(id);
	}

	private void actionDeleteBi(HttpServletRequest request) throws DALException {
		Long id = Long.parseLong(request.getParameter("BT_DELETEBI"));
		manager.deleteBiere(id);
	}
	private void actionDeleteAllBi(HttpServletRequest request) throws DALException {
		manager.deleteBi();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
