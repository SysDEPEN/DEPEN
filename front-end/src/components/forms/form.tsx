"use client";
import { useState } from "react";

interface FormData {
  select1: string;
  input1: string;
  select2: string;
  input2: string;
  [key: string]: string; // Índice de assinatura para permitir indexação por string
}

interface FormField {
  type: "select" | "input";
  label: string;
  name: string;
  inputType?: string;
}

export default function MixedForm() {
  const [formData, setFormData] = useState<FormData>({
    select1: "",
    input1: "",
    select2: "",
    input2: "",
    input3: "",
  });

  const handleChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>
  ) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const selectOptions = [
    { label: "Opção 1", value: "option1" },
    { label: "Opção 2", value: "option2" },
    { label: "Opção 3", value: "option3" },
  ];

  const formFields: FormField[] = [
    {
      type: "input",
      label: "Nome completo do visitado",
      name: "input1",
      inputType: "text",
    },
    {
      type: "input",
      label: "RG/RNE do visitado",
      name: "input2",
      inputType: "text",
    },
    { type: "select", label: "Tipo de visitação", name: "select1" },
    { type: "input", label: "Telefone", name: "input2", inputType: "text" },
    { type: "select", label: "Estado", name: "select2" },
    { type: "select", label: "Select 2", name: "select2" },
  ];

  return (
    <section className="w-full flex h-[45vw] justify-center items-center bg-white">
      <form
        className="
          flex
          bg-[#DAE2E8]
          shadow-lg
          justify-center
          items-center
          flex-col
          shadow-[#afb6bb]
          rounded
          px-8
          pt-6
          pb-8
          mb-4
          w-full
          max-w-md"
      >
        {formFields.map((field, index) => (
          <div key={index} className="mb-4">
            <label
              className="block text-gray-700 font-bold mb-2"
              htmlFor={field.name}
            >
              {field.label}
            </label>
            {field.type === "select" ? (
              <select
                className="
                  shadow 
                  appearance-none 
                  border 
                  rounded 
                  w-full 
                  py-2 
                  px-3 
                  text-gray-700 
                  leading-tight 
                  focus:outline-none 
                  focus:shadow-outline"
                id={field.name}
                name={field.name}
                value={formData[field.name]}
                onChange={handleChange}
              >
                <option value="">Selecione uma opção</option>
                {selectOptions.map((opt) => (
                  <option key={opt.value} value={opt.value}>
                    {opt.label}
                  </option>
                ))}
              </select>
            ) : (
              <input
                className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                id={field.name}
                name={field.name}
                type={field.inputType}
                value={formData[field.name]}
                onChange={handleChange}
              />
            )}
          </div>
        ))}
      </form>
    </section>
  );
}
