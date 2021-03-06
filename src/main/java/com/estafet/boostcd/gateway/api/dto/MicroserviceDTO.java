package com.estafet.boostcd.gateway.api.dto;

import com.estafet.boostcd.gateway.api.model.AppState;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MicroserviceDTO {

	private String version;
	private String name;
	private String deployedDate;
	private boolean deployed;
	private Boolean tested;

	private MicroserviceActionsDTO actions;
	private MicroserviceStateDTO state;
	
	public Boolean getTested() {
		return tested;
	}

	public void setTested(Boolean tested) {
		this.tested = tested;
	}

	public MicroserviceStateDTO getState() {
		return state;
	}

	public void setState(MicroserviceStateDTO state) {
		this.state = state;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeployedDate() {
		return deployedDate;
	}

	public void setDeployedDate(String deployedDate) {
		this.deployedDate = deployedDate;
	}

	public boolean isDeployed() {
		return deployed;
	}

	public void setDeployed(boolean deployed) {
		this.deployed = deployed;
	}

	public MicroserviceActionsDTO getActions() {
		return actions;
	}

	public void setActions(MicroserviceActionsDTO actions) {
		this.actions = actions;
	}
	
	public static MicroserviceDTOBuilder builder() {
		return new MicroserviceDTOBuilder();
	}
	
	public static class MicroserviceDTOBuilder {

		private String version;
		private String name;
		private String deployedDate;
		private boolean deployed;		
		private Boolean promoteAction;
		private Boolean buildAction;
		private AppState appState;
		private Boolean tested;

		public MicroserviceDTOBuilder setTested(Boolean tested) {
			this.tested = tested;
			return this;
		}

		public MicroserviceDTOBuilder setAppState(AppState appState) {
			this.appState = appState;
			return this;
		}

		public MicroserviceDTOBuilder setBuildAction(Boolean buildAction) {
			this.buildAction = buildAction;
			return this;
		}

		public MicroserviceDTOBuilder setPromoteAction(Boolean promoteAction) {
			this.promoteAction = promoteAction;
			return this;
		}

		public MicroserviceDTOBuilder setVersion(String version) {
			this.version = version;
			return this;
		}

		public MicroserviceDTOBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public MicroserviceDTOBuilder setDeployedDate(String deployedDate) {
			this.deployedDate = deployedDate;
			return this;
		}

		public MicroserviceDTOBuilder setDeployed(boolean deployed) {
			this.deployed = deployed;
			return this;
		}
		
		public MicroserviceDTO build() {
			MicroserviceDTO dto = new MicroserviceDTO();
			MicroserviceActionsDTO actions = new MicroserviceActionsDTO();
			MicroserviceStateDTO state = MicroserviceStateDTO.builder().setState(appState).build();
			dto.setState(state);
			dto.setVersion(version);
			dto.setName(name);
			dto.setDeployedDate(deployedDate);
			dto.setDeployed(deployed);
			dto.setActions(actions);
			dto.setTested(tested);
			if (promoteAction != null || buildAction != null) {
				actions.setPromote(promoteAction);	
				actions.setBuild(buildAction);	
			}
			return dto;
		}

	}

}
